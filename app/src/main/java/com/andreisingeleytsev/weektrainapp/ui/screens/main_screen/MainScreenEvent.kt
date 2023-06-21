package com.andreisingeleytsev.weektrainapp.ui.screens.main_screen

sealed class MainScreenEvent{
    data class Navigate(val route: String): MainScreenEvent()
    data class NavigateMainScreen(val route: String): MainScreenEvent()
}
