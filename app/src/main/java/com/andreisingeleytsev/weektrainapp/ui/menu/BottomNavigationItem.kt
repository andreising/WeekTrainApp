package com.andrei_singeleytsev.sportquizapp.presentation.menu

import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andreisingeleytsev.weektrainapp.R

sealed class BottomNavigationItem(val title: String, val icon_id: Int, val route: String) {
    object ProfileItem: BottomNavigationItem("profile", R.drawable.profile, Routes.PROFILE_SCREEN)
    object TrainingItem: BottomNavigationItem ("training", R.drawable.training, Routes.TRAINING_SCREEN)
    object StatisticItem: BottomNavigationItem ("statistics", R.drawable.statistic, Routes.STATISTIC_SCREEN)
}
