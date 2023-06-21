package com.andreisingeleytsev.weektrainapp.ui.screens.welcome_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andreisingeleytsev.weektrainapp.R
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor2

@Composable
fun WelcomeScreen(navHostController: NavHostController){
    val scroll = rememberScrollState()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MainColor)
        .verticalScroll(scroll)){
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.girl),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(text = "HELLO!", style = TextStyle(
                fontSize = 32.sp, color = Color.White, fontWeight = FontWeight.ExtraBold
            ))
            Text(text = "I AM KATE", style = TextStyle(
                fontSize = 32.sp, color = Color.White, fontWeight = FontWeight.ExtraBold
            ))
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "I am your personal trainer.", style = TextStyle(
                fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold
            ))
            Text(text = "I have a couple of questions.", style = TextStyle(
                fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold
            ))
            Text(text = "They will help you a create", style = TextStyle(
                fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold
            ))
            Text(
                text = "a personalized plan for you.", style = TextStyle(
                    fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(60.dp))
            Button(
                onClick = {
                    navHostController.navigate(Routes.ENTER_NAME_SCREEN)
                }, modifier = Modifier
                    .padding(start = 38.dp, end = 38.dp, bottom = 38.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainColor2
                )
            ) {
                Text(
                    text = "START", style = TextStyle(
                        fontSize = 32.sp, color = MainColor, fontWeight = FontWeight.ExtraBold
                    )
                )
            }
        }
    }
}