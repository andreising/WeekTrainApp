package com.andreisingeleytsev.weektrainapp.ui.screens.profile_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andrei_singeleytsev.sportquizapp.presentation.utils.UIEvent
import com.andreisingeleytsev.weektrainapp.data.entities.TrainingItem
import com.andreisingeleytsev.weektrainapp.data.entities.UserItem
import com.andreisingeleytsev.weektrainapp.data.repository.UserItemRepository
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.HARD
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.LITE
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.NORMAL
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.TrainingScreenEvent
import com.andreisingeleytsev.weektrainapp.ui.utils.TimeUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(
    private val userItemRepository: UserItemRepository
): ViewModel() {
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: ProfileScreenEvent){
        when(event) {
            is ProfileScreenEvent.OnWeightChange -> {
                sendUIEvent(UIEvent.Navigate(Routes.WEIGHT_SCREEN))
            }
            is ProfileScreenEvent.OnWeightWantChange -> {
                sendUIEvent(UIEvent.Navigate(Routes.WANNA_WEIGHT_SCREEN))
            }
            is ProfileScreenEvent.OnHeightChange -> {
                sendUIEvent(UIEvent.Navigate(Routes.HEIGHT_SCREEN))
            }
        }
    }

    private fun sendUIEvent(event: UIEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    val user = mutableStateOf(
        UserItem(
            null,
            "",
            0,
            0,
            0
        )
    )
    init {
        viewModelScope.launch {
            user.value = userItemRepository.getUserItem()
        }
    }
}