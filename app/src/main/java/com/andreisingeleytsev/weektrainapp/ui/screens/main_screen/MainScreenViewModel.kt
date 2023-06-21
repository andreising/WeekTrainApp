package com.andreisingeleytsev.weektrainapp.ui.screens.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrei_singeleytsev.sportquizapp.presentation.utils.UIEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainScreenViewModel: ViewModel() {
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: MainScreenEvent){
        when(event) {
            is MainScreenEvent.Navigate -> {
                sendUIEvent(UIEvent.NavigateMainScreen(event.route))
            }
            is MainScreenEvent.NavigateMainScreen -> {
                sendUIEvent(UIEvent.Navigate(event.route))
            }
        }
    }

    private fun sendUIEvent(event: UIEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}