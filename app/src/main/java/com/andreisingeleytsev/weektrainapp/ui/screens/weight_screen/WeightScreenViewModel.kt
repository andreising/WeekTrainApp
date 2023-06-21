package com.andreisingeleytsev.weektrainapp.ui.screens.weight_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andrei_singeleytsev.sportquizapp.presentation.utils.UIEvent
import com.andreisingeleytsev.weektrainapp.data.entities.UserItem
import com.andreisingeleytsev.weektrainapp.data.repository.UserItemRepository
import com.andreisingeleytsev.weektrainapp.ui.screens.height_screen.HeightScreenEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeightScreenViewModel @Inject constructor(
    private val repository: UserItemRepository
): ViewModel() {
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: WeightScreenEvent){
        when(event) {
            is WeightScreenEvent.OnBack -> {
                sendUIEvent(UIEvent.PopBackStack)
            }
            is WeightScreenEvent.OnNext -> {
                if (index==0){
                    viewModelScope.launch {
                        repository.insertItem(user!!.copy(weight = weight.value))
                        if (user!!.wannaWeight != null) sendUIEvent(UIEvent.PopBackStack)
                        else sendUIEvent(UIEvent.Navigate(Routes.WANNA_WEIGHT_SCREEN))
                    }
                } else {
                    viewModelScope.launch {
                        if (user!!.wannaWeight != null) {
                            repository.insertItem(user!!.copy(wannaWeight = weight.value))
                            sendUIEvent(UIEvent.PopBackStack)
                        } else {
                            repository.insertItem(user!!.copy(wannaWeight = weight.value))
                            sendUIEvent(UIEvent.Navigate(Routes.TRAINS_OFTEN_SCREEN))
                        }

                    }
                }


            }
            is WeightScreenEvent.OnWeightChange -> {
                weight.value = event.change
            }
        }
    }

    private fun sendUIEvent(event: UIEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
    var index = 0
    val weight = mutableStateOf(40)
    var user: UserItem? = null
    init {
        viewModelScope.launch {
            user = repository.getUserItem()
            val _weight = if (index==0)user!!.weight
            else user!!.wannaWeight
            weight.value = if (_weight==-1||_weight==null) 40
            else _weight
        }
    }
}