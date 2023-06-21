package com.andreisingeleytsev.weektrainapp.ui.screens.enter_name_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andrei_singeleytsev.sportquizapp.presentation.utils.UIEvent
import com.andreisingeleytsev.weektrainapp.R
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor2

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun EnterNameScreen(
    navHostController: NavHostController,
    viewModel: EnterNameScreenViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect {
            when (it) {
                is UIEvent.Navigate -> {
                    navHostController.navigate(it.route)
                }

                is UIEvent.PopBackStack -> {
                    navHostController.popBackStack()
                }

                else -> {}
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainColor)
    ) {
        Box(
            Modifier
                .padding(38.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {

            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier.height(30.dp),
                            contentScale = ContentScale.FillHeight
                        )
                    }
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        IconButton(onClick = {
                            viewModel.onEvent(EnterNameScreenEvent.OnBackButtonPressed)
                        }) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = null,
                                modifier = Modifier.size(300.dp),
                                tint = Color.White
                            )
                        }
                    }


                }
                Text(
                    text = "What is your name?", style = TextStyle(
                        fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold
                    ), modifier = Modifier.padding(top = 40.dp)
                )
                TextField(
                    modifier = Modifier
                        .padding(top = 70.dp),
                    value = viewModel.name.value,
                    onValueChange = {
                        viewModel.onEvent(EnterNameScreenEvent.OnTextChanged(it))
                    },
                    placeholder = {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Name", style = TextStyle(
                                    fontSize = 28.sp,
                                    color = Color.White.copy(alpha = 0.5f),
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }

                    },
                    textStyle = TextStyle(
                        fontSize = 28.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color.White,
                        disabledIndicatorColor = Color.White
                    )
                )

            }
            Button(
                onClick = {
                    viewModel.onEvent(EnterNameScreenEvent.OnNextButtonPressed)
                }, modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainColor2,
                    disabledContainerColor = MainColor2.copy(alpha = 0.2f)
                ),
                enabled = viewModel.name.value.isNotEmpty()
            ) {
                Text(
                    text = "NEXT", style = TextStyle(
                        fontSize = 32.sp, color = MainColor, fontWeight = FontWeight.ExtraBold
                    )
                )
            }
        }
    }
}