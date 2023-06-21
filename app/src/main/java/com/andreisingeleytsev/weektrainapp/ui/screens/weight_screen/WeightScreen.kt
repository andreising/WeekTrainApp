package com.andreisingeleytsev.weektrainapp.ui.screens.weight_screen

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andrei_singeleytsev.sportquizapp.presentation.utils.UIEvent
import com.andreisingeleytsev.weektrainapp.R
import com.andreisingeleytsev.weektrainapp.ui.screens.height_screen.HeightScreenEvent
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor2
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun WeightScreen(
    index: Int,
    navHostController: NavHostController,
    viewModel: WeightScreenViewModel = hiltViewModel()
) {
    viewModel.index = index
    val list = mutableListOf<Int>()
    for (i in 40..120) {
        list.add(i)
    }
    val pagerState = rememberPagerState()
    viewModel.weight.value = list[pagerState.currentPage]
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
                            viewModel.onEvent(WeightScreenEvent.OnBack)
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
                    text = if (index == 0) "Enter your weight"
                    else "What weight do you want", style = TextStyle(
                        fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold
                    ), modifier = Modifier.padding(top = 40.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Box(
                            modifier = Modifier
                                .size(70.dp)
                                .padding(end = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = (viewModel.weight.value-1).toString(), style = TextStyle(
                                    fontSize = 44.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )

                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.horizontalGradient(
                                            colorStops = arrayOf(
                                                0.0f to MainColor,
                                                1f to Color.Transparent
                                            )
                                        )
                                    )
                            )
                        }


                    HorizontalPager(
                        count = list.size,
                        state = pagerState,
                        modifier = Modifier
                            .width(70.dp)
                    ) {

                        Text(
                            text = list[it].toString(), style = TextStyle(
                                fontSize = 58.sp, color = Color.White, fontWeight = FontWeight.Bold
                            )
                        )

                    }
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .padding(start = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = (viewModel.weight.value+1).toString(), style = TextStyle(
                                    fontSize = 44.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.horizontalGradient(
                                            colorStops = arrayOf(
                                                0.0f to Color.Transparent,
                                                1f to MainColor
                                            )
                                        )
                                    )
                            )
                        }

                }

                Image(
                    painter = painterResource(id = R.drawable.weight_img),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
            Button(
                onClick = {
                    viewModel.onEvent(WeightScreenEvent.OnNext)
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