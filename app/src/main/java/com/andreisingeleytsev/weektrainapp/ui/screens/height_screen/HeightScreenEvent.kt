package com.andreisingeleytsev.weektrainapp.ui.screens.height_screen

sealed class HeightScreenEvent{
    object OnBack: HeightScreenEvent()
    object OnNext: HeightScreenEvent()
    data class OnHeightChange(val change: Double): HeightScreenEvent()
}



