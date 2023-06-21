package com.andreisingeleytsev.weektrainapp.ui.screens.main_screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.andrei_singeleytsev.sportquizapp.presentation.menu.BottomNavigationMenu
import com.andrei_singeleytsev.sportquizapp.presentation.utils.UIEvent
import com.andreisingeleytsev.weektrainapp.ui.navigation.MainScreenNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(mainNavHostController: NavHostController, viewModel: MainScreenViewModel = hiltViewModel()) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
            when(uiEvent) {
                is UIEvent.NavigateMainScreen ->{
                    mainNavHostController.navigate(uiEvent.route)
                }
                is UIEvent.Navigate -> {
                    navController.navigate(uiEvent.route)
                }
                else ->{}
            }
        }
    }
    Scaffold(bottomBar = {
        BottomNavigationMenu(currentRoute = currentRoute) { route ->
            viewModel.onEvent(MainScreenEvent.NavigateMainScreen(route))
        }
    }) {
        MainScreenNavigation(navController, it){route->
            viewModel.onEvent(MainScreenEvent.Navigate(route))
        }
    }
}