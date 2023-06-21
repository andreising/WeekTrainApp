package com.andreisingeleytsev.weektrainapp.ui.screens.statistic_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andrei_singeleytsev.sportquizapp.presentation.utils.UIEvent
import com.andreisingeleytsev.weektrainapp.data.entities.TrainingItem
import com.andreisingeleytsev.weektrainapp.data.repository.TrainingItemRepository
import com.andreisingeleytsev.weektrainapp.ui.screens.weight_screen.WeightScreenEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatisticScreenViewModel @Inject constructor(
    val repository: TrainingItemRepository
): ViewModel() {
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: StatisticScreenEvent){
        when(event) {
            is StatisticScreenEvent.OnBack -> {
                isCategorySelected.value = false
            }
            is StatisticScreenEvent.OnSelectCategory -> {
                isCategorySelected.value = true
                category.value = event.cat
            }
        }
    }

    val listCardio = mutableStateOf(
        listOf<TrainingItem>()
    )
    val listPower = mutableStateOf(
        listOf<TrainingItem>()
    )
    val listStretching = mutableStateOf(
        listOf<TrainingItem>()
    )
    val listYoga = mutableStateOf(
        listOf<TrainingItem>()
    )
    val listCrossfit = mutableStateOf(
        listOf<TrainingItem>()
    )
    val isCategorySelected = mutableStateOf(false)
    val category = mutableStateOf("")
    init {
        viewModelScope.launch {
            listCardio.value = repository.getCardio()
            listPower.value = repository.getPower()
            listStretching.value = repository.getStretching()
            listYoga.value = repository.getYoga()
            listCrossfit.value = repository.getCrossfit()
        }
    }
}