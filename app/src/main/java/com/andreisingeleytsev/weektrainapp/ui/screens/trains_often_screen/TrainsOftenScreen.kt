package com.andreisingeleytsev.weektrainapp.ui.screens.trains_often_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andrei_singeleytsev.sportquizapp.presentation.utils.Routes
import com.andreisingeleytsev.weektrainapp.R
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor2

@Composable
fun TrainsOftenScreen(navHostController: NavHostController){
    val list = listOf(
        remember {
            mutableStateOf(MainColor)
        },
        remember {
            mutableStateOf(MainColor)
        },
        remember {
            mutableStateOf(MainColor)
        },
        remember {
            mutableStateOf(MainColor)
        },
        remember {
            mutableStateOf(MainColor)
        }
    )
    val currentBox = remember {
        mutableStateOf(2)
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
                            navHostController.popBackStack()
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
                    text = "How often do you exercise?", style = TextStyle(
                        fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold
                    ), modifier = Modifier.padding(top = 40.dp),
                    textAlign = TextAlign.Center
                )
                Box(modifier = Modifier
                    .padding(top = 26.dp)
                    .size(180.dp), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.calendar),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = (currentBox.value+1).toString(), style = TextStyle(
                            fontSize = 96.sp, color = MainColor, fontWeight = FontWeight.Bold
                        ), modifier = Modifier.padding(top = 40.dp)
                    )
                }
                Row(modifier = Modifier.padding(top = 24.dp)) {
                    Text(
                        text = "3", style = TextStyle(
                            fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = " times a week", style = TextStyle(
                            fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold
                        )
                    )
                }
                Text(
                    text = "*Tip: in order to reach your goals ", style = TextStyle(
                        fontSize = 16.sp, color = Color.White.copy(alpha = 0.5f), fontWeight = FontWeight.SemiBold
                    ), modifier = Modifier.padding(top = 8.dp), textAlign = TextAlign.Center
                )
                Text(
                    text = "faster, you need to train 3 times", style = TextStyle(
                        fontSize = 16.sp, color = Color.White.copy(alpha = 0.5f), fontWeight = FontWeight.SemiBold
                    ),  textAlign = TextAlign.Center
                )
                Text(
                    text = "a week", style = TextStyle(
                        fontSize = 16.sp, color = Color.White.copy(alpha = 0.5f), fontWeight = FontWeight.SemiBold
                    ),  textAlign = TextAlign.Center
                )
                val selectedCircleIndex = remember { mutableStateOf(-1) }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(

                        text = "lite", style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White.copy(alpha = 0.5f),
                            fontWeight = FontWeight.SemiBold
                        ), textAlign = TextAlign.Center
                    )
                    Column(modifier = Modifier.width(200.dp)) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(
                                text = "1", style = TextStyle(
                                    fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "2", style = TextStyle(
                                    fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "3", style = TextStyle(
                                    fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "4", style = TextStyle(
                                    fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "5", style = TextStyle(
                                    fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold
                                )
                            )
                        }
                        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .height(3.dp)
                                .background(Color.White))
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                list[currentBox.value].value= Color.White
                                Box(
                                    modifier = Modifier
                                        .size(14.dp)
                                        .clip(CircleShape)
                                        .background(

                                            list[0].value
                                        )
                                        .border(2.dp, color = Color.White)
                                        .clickable {
                                            list[currentBox.value].value= MainColor
                                            currentBox.value = 0
                                        }
                                )
                                Box(
                                    modifier = Modifier
                                        .size(14.dp)
                                        .clip(CircleShape)
                                        .background(
                                            list[1].value
                                        )
                                        .border(2.dp, color = Color.White)
                                        .clickable {
                                            list[currentBox.value].value= MainColor
                                            currentBox.value = 1
                                        }
                                )
                                Box(
                                    modifier = Modifier
                                        .size(14.dp)
                                        .clip(CircleShape)
                                        .background(
                                            list[2].value
                                        )
                                        .border(2.dp, color = Color.White)
                                        .clickable {
                                            list[currentBox.value].value= MainColor
                                            currentBox.value = 2
                                        }
                                )
                                Box(
                                    modifier = Modifier
                                        .size(14.dp)
                                        .clip(CircleShape)
                                        .background(
                                            list[3].value
                                        )
                                        .border(2.dp, color = Color.White)
                                        .clickable {
                                            list[currentBox.value].value= MainColor
                                            currentBox.value = 3
                                        }
                                )
                                Box(
                                    modifier = Modifier
                                        .size(14.dp)
                                        .clip(CircleShape)
                                        .background(
                                            list[4].value
                                        )
                                        .border(2.dp, color = Color.White)
                                        .clickable {
                                            list[currentBox.value].value= MainColor
                                            currentBox.value = 4
                                        }
                                )
                            }

                        }
                    }
                    Text(
                        text = "hard", style = TextStyle(
                            fontSize = 16.sp, color = Color.White.copy(alpha = 0.5f), fontWeight = FontWeight.SemiBold
                        ),  textAlign = TextAlign.Center
                    )
                }


            }
            Button(
                onClick = {
                    navHostController.navigate(Routes.MAIN_SCREEN){
                        popUpTo(Routes.WELCOME_SCREEN){
                            inclusive = true
                        }
                    }
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