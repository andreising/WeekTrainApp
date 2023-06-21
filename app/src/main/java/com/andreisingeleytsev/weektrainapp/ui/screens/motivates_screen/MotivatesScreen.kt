package com.andreisingeleytsev.weektrainapp.ui.screens.motivates_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun MotivatesScreen(navHostController: NavHostController) {
    val list = listOf(
        remember {
            mutableStateOf(false)
        },
        remember {
            mutableStateOf(false)
        },
        remember {
            mutableStateOf(false)
        },
        remember {
            mutableStateOf(false)
        },
        remember {
            mutableStateOf(false)
        }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainColor)
    ) {
        Box(
            Modifier
                .padding(38.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){

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
                            painter = painterResource(id = R.drawable.logo), contentDescription = null,
                            modifier = Modifier.height(30.dp), contentScale = ContentScale.FillHeight
                        )
                    }
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart){
                        IconButton(onClick = {

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
                    text = "What motivates you?", style = TextStyle(
                        fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold
                    ), modifier = Modifier.padding(top = 40.dp)
                )
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp), contentAlignment = Alignment.CenterEnd) {
                    Image(
                        painter = painterResource(id = R.drawable.motivate1),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    RadioButton(selected = list[0].value, onClick = {
                        list[0].value = !list[0].value
                    },
                        modifier = Modifier.size(60.dp),
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Color.White,
                        selectedColor = Color.White
                    ))
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp), contentAlignment = Alignment.CenterEnd) {
                    Image(
                        painter = painterResource(id = R.drawable.motivate2),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    RadioButton(
                        selected = list[1].value, onClick = {
                            list[1].value = !list[1].value
                        },
                        modifier = Modifier.size(60.dp),
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Color.White,
                        selectedColor = Color.White
                    ))
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp), contentAlignment = Alignment.CenterEnd) {
                    Image(
                        painter = painterResource(id = R.drawable.motivate3),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    RadioButton(selected = list[2].value, onClick = {
                        list[2].value = !list[2].value
                    },
                        modifier = Modifier.size(60.dp),
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Color.White,
                        selectedColor = Color.White
                    ))
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp), contentAlignment = Alignment.CenterEnd) {
                    Image(
                        painter = painterResource(id = R.drawable.motivate4),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    RadioButton(selected = list[3].value, onClick = {
                        list[3].value = !list[3].value
                    },
                        modifier = Modifier.size(60.dp),
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Color.White,
                        selectedColor = Color.White
                    ))
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp), contentAlignment = Alignment.CenterEnd) {
                    Image(
                        painter = painterResource(id = R.drawable.motivate5),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    RadioButton(selected = list[4].value, onClick = {
                        list[4].value = !list[4].value
                    },
                        modifier = Modifier.size(60.dp),
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Color.White,
                        selectedColor = Color.White
                    ))
                }

            }
            Button(
                onClick = {
                    var res = false
                    list.forEach {
                        if(it.value){
                            res = true
                            return@forEach
                        }
                    }
                    if (res) navHostController.navigate(Routes.HEIGHT_SCREEN)
                }, modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainColor2
                )
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