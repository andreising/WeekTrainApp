package com.andreisingeleytsev.weektrainapp.ui.screens.height_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andrei_singeleytsev.sportquizapp.presentation.utils.UIEvent
import com.andreisingeleytsev.weektrainapp.data.entities.UserItem
import com.andreisingeleytsev.weektrainapp.data.repository.UserItemRepository
import com.andreisingeleytsev.weektrainapp.ui.screens.enter_name_screen.EnterNameScreenEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeightScreenViewModel @Inject constructor(
    private val repository: UserItemRepository
): ViewModel() {
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: HeightScreenEvent){
        when(event) {
            is HeightScreenEvent.OnBack -> {
                sendUIEvent(UIEvent.PopBackStack)
            }
            is HeightScreenEvent.OnNext -> {
                viewModelScope.launch {
                    repository.insertItem(user!!.copy(height = height.value))
                }
                if (user!!.wannaWeight!=null) sendUIEvent(UIEvent.PopBackStack)
                else sendUIEvent(UIEvent.Navigate(Routes.WEIGHT_SCREEN))
            }
            is HeightScreenEvent.OnHeightChange -> {
                height.value = (50 + 150*event.change).toInt()
            }
        }
    }

    private fun sendUIEvent(event: UIEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
    val height = mutableStateOf(200)
    var user: UserItem? = null
    init {
        viewModelScope.launch {
            user = repository.getUserItem()
            val _height = user!!.height
            height.value = if (_height==-1) 200
            else _height
        }
    }
}