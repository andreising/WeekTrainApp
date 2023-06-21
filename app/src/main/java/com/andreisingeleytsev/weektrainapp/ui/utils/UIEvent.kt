package com.andrei_singeleytsev.sportquizapp.presentation.utils

sealed class UIEvent{
    object PopBackStack: UIEvent()
    data class Navigate(val route: String): UIEvent()
    data class NavigateMainScreen(val route: String): UIEvent()
}
