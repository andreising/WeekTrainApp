package com.andreisingeleytsev.weektrainapp.ui.screens.enter_name_screen

sealed class EnterNameScreenEvent{
    object OnBackButtonPressed: EnterNameScreenEvent()
    object OnNextButtonPressed: EnterNameScreenEvent()
    data class OnTextChanged(val string: String): EnterNameScreenEvent()
}
