package com.andreisingeleytsev.weektrainapp.ui.screens.training_screen

import android.widget.Chronometer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andrei_singeleytsev.sportquizapp.presentation.utils.UIEvent
import com.andreisingeleytsev.weektrainapp.data.entities.TrainingItem
import com.andreisingeleytsev.weektrainapp.data.repository.TrainingItemRepository
import com.andreisingeleytsev.weektrainapp.ui.screens.main_screen.MainScreenEvent
import com.andreisingeleytsev.weektrainapp.ui.screens.weight_screen.WeightScreenEvent
import com.andreisingeleytsev.weektrainapp.ui.utils.TimeUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask
import javax.inject.Inject

@HiltViewModel
class TrainingScreenViewModel @Inject constructor(
    private val repository: TrainingItemRepository
): ViewModel() {
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: TrainingScreenEvent){
        when(event) {
            is TrainingScreenEvent.OnCategorySelect -> {
                isCategorySelected.value = true
                category.value = event.category
            }
            is TrainingScreenEvent.OnDifficultyChanged -> {
                difficulty.value = when(event.index) {
                    0 -> LITE
                    1-> NORMAL
                    2-> HARD
                    else -> LITE
                }
            }
            is TrainingScreenEvent.OnBack -> {
                timer?.cancel()
                isCategorySelected.value = false
            }
            is TrainingScreenEvent.OnStartStopPressed -> {
                if (isGoing.value){
                    stopTimer()
                    viewModelScope.launch {
                        repository.insertItem(
                            TrainingItem(
                                null,
                                name.value,
                                category.value,
                                difficulty.value,
                                TimeUtils.getTime(seconds.value.toLong())
                            )
                        )
                    }
                    sendUIEvent(UIEvent.NavigateMainScreen(Routes.STATISTIC_SCREEN))
                } else {
                    isGoing.value = true
                    startTimer()
                }
            }
        }
    }

    private fun sendUIEvent(event: UIEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
    val isCategorySelected = mutableStateOf(false)
    val name = mutableStateOf("")
    val category = mutableStateOf("")
    val difficulty = mutableStateOf("")
    val isGoing = mutableStateOf(false)

    private var timer: Timer? = null
    val seconds = mutableStateOf(0)

    private fun startTimer() {
        timer = Timer()
        timer?.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                seconds.value+=1000
            }
        }, 0, 1000)
    }

    fun stopTimer() {
        timer?.cancel()
    }
}
const val LITE = "lite"
const val NORMAL = "normal"
const val HARD = "hard"