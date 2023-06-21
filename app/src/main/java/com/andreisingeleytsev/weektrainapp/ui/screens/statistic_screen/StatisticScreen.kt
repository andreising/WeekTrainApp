package com.andreisingeleytsev.weektrainapp.ui.screens.statistic_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.andreisingeleytsev.weektrainapp.R
import com.andreisingeleytsev.weektrainapp.data.entities.TrainingItem
import com.andreisingeleytsev.weektrainapp.ui.screens.height_screen.HeightScreenEvent
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.CARDIO
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.CROSSFIT
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.POWER
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.STRETCHING
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.YOGA
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor2

@Composable
fun StatisticScreen(paddingValues: PaddingValues, viewModel: StatisticScreenViewModel = hiltViewModel()){
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(MainColor),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(painter = painterResource(id = R.drawable.main_screen_bg), contentDescription = null,
            modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
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
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 22.dp)
                        .clickable {
                            viewModel.onEvent(StatisticScreenEvent.OnSelectCategory(CARDIO))
                        }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 25.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.stat_cardio),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(186.dp)
                                    .padding(start = 12.dp),
                                contentScale = ContentScale.FillWidth
                            )
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = viewModel.listCardio.value.size.toString(), style = TextStyle(
                                        fontSize = 28.sp,
                                        color = MainColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "trainings", style = TextStyle(
                                        fontSize = 16.sp,
                                        color = MainColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        }
                    }
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 22.dp)
                        .clickable {
                            viewModel.onEvent(StatisticScreenEvent.OnSelectCategory(POWER))
                        }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 25.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.stat_power),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(186.dp)
                                    .padding(start = 12.dp),
                                contentScale = ContentScale.FillWidth
                            )
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = viewModel.listPower.value.size.toString(), style = TextStyle(
                                        fontSize = 28.sp,
                                        color = MainColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "trainings", style = TextStyle(
                                        fontSize = 16.sp,
                                        color = MainColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }

                        }

                    }
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 22.dp)
                        .clickable {
                            viewModel.onEvent(StatisticScreenEvent.OnSelectCategory(STRETCHING))
                        }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 25.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.stat_stretching),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(186.dp)
                                    .padding(start = 12.dp),
                                contentScale = ContentScale.FillWidth
                            )
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = viewModel.listStretching.value.size.toString(), style = TextStyle(
                                        fontSize = 28.sp,
                                        color = MainColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "trainings", style = TextStyle(
                                        fontSize = 16.sp,
                                        color = MainColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }

                        }

                    }
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 22.dp)
                        .clickable {
                            viewModel.onEvent(StatisticScreenEvent.OnSelectCategory(YOGA))
                        }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 25.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.stat_yoga),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(186.dp)
                                    .padding(start = 12.dp),
                                contentScale = ContentScale.FillWidth
                            )
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = viewModel.listYoga.value.size.toString(), style = TextStyle(
                                        fontSize = 28.sp,
                                        color = MainColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "trainings", style = TextStyle(
                                        fontSize = 16.sp,
                                        color = MainColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }

                        }

                    }
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 22.dp)
                        .clickable {
                            viewModel.onEvent(StatisticScreenEvent.OnSelectCategory(CROSSFIT))
                        }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 25.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.stat_crosfit),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(186.dp)
                                    .padding(start = 12.dp),
                                contentScale = ContentScale.FillWidth
                            )
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = viewModel.listCrossfit.value.size.toString(), style = TextStyle(
                                        fontSize = 28.sp,
                                        color = MainColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "trainings", style = TextStyle(
                                        fontSize = 16.sp,
                                        color = MainColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }

                        }

                    }
                }
            }
        } else {
            val list = when(viewModel.category.value){
                CARDIO -> viewModel.listCardio.value
                POWER -> viewModel.listPower.value
                STRETCHING -> viewModel.listStretching.value
                YOGA -> viewModel.listYoga.value
                CROSSFIT -> viewModel.listCrossfit.value
                else -> viewModel.listYoga.value
            }
            Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
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
                            viewModel.onEvent(StatisticScreenEvent.OnBack)
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
                        fontSize = 36.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
                if (list.isEmpty()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                        Image(
                            painter = painterResource(id = R.drawable.add_workout),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.FillWidth
                        )
                    }
                } else{
                    LazyColumn(Modifier.fillMaxSize()){
                        items(list){
                            ListItem(trainingItem = it)
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun ListItem(trainingItem: TrainingItem) {
    Card(modifier = Modifier.fillMaxWidth().padding(18.dp), shape = RoundedCornerShape(10.dp)) {
        Row(
            modifier = Modifier
                .padding(23.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = trainingItem.name, style = TextStyle(
                    fontSize = 28.sp,
                    color = MainColor,
                    fontWeight = FontWeight.Bold
                ))
                Text(text = trainingItem.difficulty, style = TextStyle(
                    fontSize = 16.sp,
                    color = MainColor,
                    fontWeight = FontWeight.Bold
                ))
            }
            Text(text = trainingItem.time, style = TextStyle(
                fontSize = 40.sp,
                color = MainColor,
                fontWeight = FontWeight.Bold
            ))
        }
    }
}