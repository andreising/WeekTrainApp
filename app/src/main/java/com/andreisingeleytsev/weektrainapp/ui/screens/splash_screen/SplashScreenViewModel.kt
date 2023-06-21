package com.andreisingeleytsev.weektrainapp.ui.screens.splash_screen

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andrei_singeleytsev.sportquizapp.presentation.utils.UIEvent
import com.andreisingeleytsev.weektrainapp.data.repository.UserItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.lang.NullPointerException
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val userItemRepository: UserItemRepository
): ViewModel() {
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private fun sendUIEvent(event: UIEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
    private var nextScreen = Routes.MAIN_SCREEN
    init {
        viewModelScope.launch {
            try {
                if (userItemRepository.isFirstLaunch()) nextScreen = Routes.WELCOME_SCREEN
            } catch (e: NullPointerException) {
                nextScreen = Routes.WELCOME_SCREEN
            }

            delay(3000)
            sendUIEvent(UIEvent.Navigate(nextScreen))
        }
    }
}