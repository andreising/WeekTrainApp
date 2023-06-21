package com.andreisingeleytsev.weektrainapp.ui.screens.profile_screen

sealed class ProfileScreenEvent{
    object OnHeightChange: ProfileScreenEvent()
    object OnWeightChange: ProfileScreenEvent()
    object OnWeightWantChange: ProfileScreenEvent()
}
