package com.andreisingeleytsev.weektrainapp.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andreisingeleytsev.weektrainapp.ui.screens.profile_screen.ProfileScreen
import com.andreisingeleytsev.weektrainapp.ui.screens.splash_screen.SplashScreen
import com.andreisingeleytsev.weektrainapp.ui.screens.statistic_screen.StatisticScreen
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.TrainingScreen

@Composable
fun MainScreenNavigation(navController: NavHostController, padding: PaddingValues, onNavigate: (String)->Unit) {

    NavHost(navController = navController, startDestination = Routes.TRAINING_SCREEN) {
        composable(Routes.PROFILE_SCREEN) {
            ProfileScreen(padding, onNavigate)
        }
        composable(Routes.TRAINING_SCREEN) {
            TrainingScreen(padding, navController)
        }
        composable(Routes.STATISTIC_SCREEN) {
            StatisticScreen(padding)
        }
    }
}