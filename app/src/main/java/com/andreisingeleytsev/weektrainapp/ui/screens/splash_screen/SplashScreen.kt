package com.andreisingeleytsev.weektrainapp.ui.screens.splash_screen

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andrei_singeleytsev.sportquizapp.presentation.utils.UIEvent
import com.andreisingeleytsev.weektrainapp.R
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor


@Composable
fun SplashScreen(navHostController: NavHostController, viewModel: SplashScreenViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{
            when(it) {
                is UIEvent.Navigate -> {
                    navHostController.navigate(it.route){
                        popUpTo(Routes.SPLASH_SCREEN){
                            inclusive = true
                        }
                    }
                }
                else -> {}
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainColor), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_background), contentDescription = null,
            contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize()
        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 40.dp, end = 40.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
    }
}