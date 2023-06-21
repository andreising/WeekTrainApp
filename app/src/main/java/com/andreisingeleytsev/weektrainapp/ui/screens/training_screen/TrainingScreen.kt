package com.andreisingeleytsev.weektrainapp.ui.screens.training_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.andreisingeleytsev.weektrainapp.ui.screens.enter_name_screen.EnterNameScreenEvent
import com.andreisingeleytsev.weektrainapp.ui.screens.main_screen.MainScreenEvent
import com.andreisingeleytsev.weektrainapp.ui.screens.weight_screen.WeightScreenEvent
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor2
import com.andreisingeleytsev.weektrainapp.ui.utils.TimeUtils


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainingScreen(paddingValues: PaddingValues, navHostController: NavHostController, viewModel: TrainingScreenViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
            when(uiEvent) {
                is UIEvent.NavigateMainScreen ->{
                    navHostController.navigate(uiEvent.route)
                }
                else ->{}
            }
        }
    }
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(MainColor)
            .verticalScroll(rememberScrollState())
    ) {
        if (!viewModel.isCategorySelected.value){
            Box(
                Modifier
                    .padding(18.dp)
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
                    }

                    IconButton(
                        onClick = {
                            viewModel.onEvent(TrainingScreenEvent.OnCategorySelect(CARDIO))
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp)
                            .height(120.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.btn_cardio),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillWidth
                        )
                    }
                    IconButton(onClick = { viewModel.onEvent(TrainingScreenEvent.OnCategorySelect(
                        POWER)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(120.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.btn_power),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillWidth
                        )
                    }
                    IconButton(onClick = { viewModel.onEvent(TrainingScreenEvent.OnCategorySelect(
                        STRETCHING)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(120.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.btn_stretching),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillWidth
                        )
                    }
                    IconButton(onClick = { viewModel.onEvent(TrainingScreenEvent.OnCategorySelect(
                        YOGA)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(120.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.btn_yoga),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillWidth
                        )
                    }
                    IconButton(onClick = { viewModel.onEvent(TrainingScreenEvent.OnCategorySelect(
                        CROSSFIT)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(120.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.btn_crossfit),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillWidth
                        )
                    }

                }
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MainColor),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.main_screen_bg),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                Column(
                    Modifier
                        .padding(18.dp)
                        .fillMaxSize(),
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
                                viewModel.onEvent(TrainingScreenEvent.OnBack)
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
                        text = viewModel.category.value, style = TextStyle(
                            fontSize = 36.sp, color = Color.White, fontWeight = FontWeight.Bold
                        )
                    )
                    Card(modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 50.dp), shape = RoundedCornerShape(10.dp)) {
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .background(Color.White),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            TextField(
                                modifier = Modifier
                                    .padding(top = 24.dp, start = 40.dp, end = 40.dp),
                                value = viewModel.name.value,
                                onValueChange = {
                                    viewModel.name.value = it
                                },
                                placeholder = {
                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "Name", style = TextStyle(
                                                fontSize = 28.sp,
                                                color = MainColor.copy(alpha = 0.3f),
                                                fontWeight = FontWeight.Bold
                                            )
                                        )
                                    }

                                },
                                textStyle = TextStyle(
                                    fontSize = 28.sp,
                                    color = MainColor,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                ),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color.Transparent,
                                    focusedIndicatorColor = MainColor,
                                    unfocusedIndicatorColor = MainColor,
                                    disabledIndicatorColor = MainColor
                                )
                            )
                            Column(
                                modifier = Modifier.padding(
                                    top = 30.dp,
                                    start = 65.dp,
                                    end = 65.dp
                                )
                            ) {
                                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                    Text(
                                        text = "lite", style = TextStyle(
                                            fontSize = 16.sp, color = MainColor, fontWeight = FontWeight.Bold
                                        )
                                    )
                                    Text(
                                        text = "normal", style = TextStyle(
                                            fontSize = 16.sp, color = MainColor, fontWeight = FontWeight.Bold
                                        )
                                    )
                                    Text(
                                        text = "hard", style = TextStyle(
                                            fontSize = 16.sp, color = MainColor, fontWeight = FontWeight.Bold
                                        )
                                    )
                                }
                                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .height(3.dp)
                                        .background(MainColor))
                                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                        Box(
                                            modifier = Modifier
                                                .size(14.dp)
                                                .clip(CircleShape)
                                                .background(
                                                    if (viewModel.difficulty.value == LITE) MainColor
                                                    else Color.White
                                                )
                                                .border(2.dp, color = MainColor)
                                                .clickable {
                                                    viewModel.onEvent(
                                                        TrainingScreenEvent.OnDifficultyChanged(
                                                            0
                                                        )
                                                    )
                                                }
                                        )
                                        Box(
                                            modifier = Modifier
                                                .size(14.dp)
                                                .clip(CircleShape)
                                                .background(
                                                    if (viewModel.difficulty.value == NORMAL) MainColor
                                                    else Color.White
                                                )
                                                .border(2.dp, color = MainColor)
                                                .clickable {
                                                    viewModel.onEvent(
                                                        TrainingScreenEvent.OnDifficultyChanged(
                                                            1
                                                        )
                                                    )
                                                }
                                        )
                                        Box(
                                            modifier = Modifier
                                                .size(14.dp)
                                                .clip(CircleShape)
                                                .background(
                                                    if (viewModel.difficulty.value == HARD) MainColor
                                                    else Color.White
                                                )
                                                .border(2.dp, color = MainColor)
                                                .clickable {
                                                    viewModel.onEvent(
                                                        TrainingScreenEvent.OnDifficultyChanged(
                                                            2
                                                        )
                                                    )
                                                }
                                        )
                                    }
                                }
                            }
                            Text(
                                text = TimeUtils.getTime(viewModel.seconds.value.toLong()), style = TextStyle(
                                    fontSize = 40.sp,
                                    color = MainColor,
                                    fontWeight = FontWeight.Bold
                                ), modifier = Modifier.padding(top = 16.dp)
                            )
                            Button(
                                onClick = {
                                    viewModel.onEvent(TrainingScreenEvent.OnStartStopPressed)
                                }, modifier = Modifier
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MainColor2,
                                    disabledContainerColor = MainColor2.copy(alpha = 0.2f)
                                ),
                                enabled = viewModel.name.value.isNotEmpty() && viewModel.difficulty.value.isNotEmpty()
                            ) {
                                Text(
                                    text = if (viewModel.isGoing.value) "Stop"
                                    else "Start", style = TextStyle(
                                        fontSize = 32.sp,
                                        color = MainColor,
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                )
                            }
                        }
                    }

                }

            }
        }
    }
}
const val CARDIO = "cardio"
const val POWER = "power"
const val STRETCHING = "stretching"
const val YOGA = "yoga"
const val CROSSFIT = "crossfit"
