package com.andreisingeleytsev.weektrainapp.ui.screens.weight_screen

import com.andreisingeleytsev.weektrainapp.ui.screens.height_screen.HeightScreenEvent

sealed class WeightScreenEvent{
    object OnBack: WeightScreenEvent()
    object OnNext: WeightScreenEvent()
    data class OnWeightChange(val change: Int): WeightScreenEvent()
}
