package com.andreisingeleytsev.weektrainapp.ui.screens.statistic_screen

sealed class StatisticScreenEvent{
    object OnBack: StatisticScreenEvent()
    data class OnSelectCategory(val cat: String): StatisticScreenEvent()
}
