package com.andreisingeleytsev.weektrainapp.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andreisingeleytsev.weektrainapp.ui.screens.enter_name_screen.EnterNameScreen
import com.andreisingeleytsev.weektrainapp.ui.screens.height_screen.HeightScreen
import com.andreisingeleytsev.weektrainapp.ui.screens.main_screen.MainScreen
import com.andreisingeleytsev.weektrainapp.ui.screens.motivates_screen.MotivatesScreen
import com.andreisingeleytsev.weektrainapp.ui.screens.splash_screen.SplashScreen
import com.andreisingeleytsev.weektrainapp.ui.screens.trains_often_screen.TrainsOftenScreen
import com.andreisingeleytsev.weektrainapp.ui.screens.weight_screen.WeightScreen
import com.andreisingeleytsev.weektrainapp.ui.screens.welcome_screen.WelcomeScreen

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun WeekTrainMainNavigation() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = Routes.SPLASH_SCREEN) {
        composable(Routes.SPLASH_SCREEN) {
            SplashScreen(navHostController)
        }
        composable(Routes.MAIN_SCREEN) {
            MainScreen(navHostController)
        }
        composable(Routes.WELCOME_SCREEN) {
            WelcomeScreen(navHostController)
        }
        composable(Routes.ENTER_NAME_SCREEN) {
            EnterNameScreen(navHostController)
        }
        composable(Routes.MOTIVATES_SCREEN) {
            MotivatesScreen(navHostController)
        }
        composable(Routes.HEIGHT_SCREEN) {
            HeightScreen(navHostController)
        }
        composable(Routes.WEIGHT_SCREEN) {
            WeightScreen(0,navHostController)
        }
        composable(Routes.WANNA_WEIGHT_SCREEN) {
            WeightScreen(1,navHostController)
        }
        composable(Routes.TRAINS_OFTEN_SCREEN) {
            TrainsOftenScreen(navHostController)
        }
    }
}