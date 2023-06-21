package com.andreisingeleytsev.weektrainapp.ui.screens.training_screen

sealed class TrainingScreenEvent{
    data class OnCategorySelect(val category: String): TrainingScreenEvent()
    data class OnDifficultyChanged(val index: Int): TrainingScreenEvent()
    object OnStartStopPressed: TrainingScreenEvent()
    object OnBack: TrainingScreenEvent()
}
