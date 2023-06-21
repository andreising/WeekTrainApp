package com.andreisingeleytsev.weektrainapp.ui.screens.enter_name_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andrei_singeleytsev.sportquizapp.presentation.utils.UIEvent
import com.andreisingeleytsev.weektrainapp.data.entities.UserItem
import com.andreisingeleytsev.weektrainapp.data.repository.UserItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.lang.NullPointerException
import javax.inject.Inject

@HiltViewModel
class EnterNameScreenViewModel @Inject constructor(
    private val userItemRepository: UserItemRepository
): ViewModel() {
    val name = mutableStateOf("")
    var user: UserItem? = null
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: EnterNameScreenEvent){
        when(event) {
            is EnterNameScreenEvent.OnBackButtonPressed -> {
                sendUIEvent(UIEvent.PopBackStack)
            }
            is EnterNameScreenEvent.OnNextButtonPressed -> {
                viewModelScope.launch {
                    if (user != null) {
                        userItemRepository.insertItem(user!!.copy(name = name.value))
                    } else {
                        userItemRepository.insertItem(
                            UserItem(
                                null,
                                name.value,
                                -1, -1, null
                            )
                        )
                    }

                }
                sendUIEvent(UIEvent.Navigate(Routes.MOTIVATES_SCREEN))
            }
            is EnterNameScreenEvent.OnTextChanged -> {
                name.value = event.string
            }
        }

    }

    private fun sendUIEvent(event: UIEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
    init {
        viewModelScope.launch {
            try {
                user = userItemRepository.getUserItem()
                name.value = user!!.name
            } catch (_:NullPointerException) {}
        }

    }
}