package com.andreisingeleytsev.weektrainapp.ui.screens.height_screen

import android.util.Log
import android.view.MotionEvent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
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
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor2

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HeightScreen(
    navHostController: NavHostController,
    viewModel: HeightScreenViewModel = hiltViewModel()
) {
    var offsetY by remember { mutableStateOf(0f) }
    val height = 400.dp
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
            .background(MainColor),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            Modifier
                .padding(38.dp)
                .fillMaxSize()
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
                            painter = painterResource(id = R.drawable.logo), contentDescription = null,
                            modifier = Modifier.height(30.dp), contentScale = ContentScale.FillHeight
                        )
                    }
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart){
                        IconButton(onClick = {
                            viewModel.onEvent(HeightScreenEvent.OnBack)
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
                    text = "Indicate your height", style = TextStyle(
                        fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold
                    ), modifier = Modifier.padding(top = 40.dp)
                )
                Text(
                    text = viewModel.height.value.toString(), style = TextStyle(
                        fontSize = 48.sp, color = Color.White, fontWeight = FontWeight.Bold
                    ), modifier = Modifier.padding(top = 40.dp)
                )


            }

        }
        Column(Modifier.padding(bottom = 75.dp)) {
            Image(
                painter = painterResource(id = R.drawable.girl2),
                contentDescription = null,
                modifier = Modifier.height(350.dp),
                contentScale = ContentScale.FillHeight
            )
            Button(
                onClick = {
                    viewModel.onEvent(HeightScreenEvent.OnNext)
                }, modifier = Modifier
                    .padding(start = 38.dp, end = 38.dp)
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
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd) {
            Box(modifier = Modifier.height(height), contentAlignment = Alignment.BottomEnd) {
                val density = LocalContext.current.resources.displayMetrics.density
                Image(
                    painter = painterResource(id = R.drawable.height_number),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = 50.dp),
                    contentScale = ContentScale.FillHeight
                )
                Image(
                    painter = painterResource(id = R.drawable.height_size),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = 20.dp)
                        .pointerInteropFilter { event ->
                            when (event.action) {
                                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                                    if (event.y in 0f..(height * density).value) {
                                        val currentHeight =
                                            ((height * density).value - event.y) / (height * density).value
                                        viewModel.onEvent(
                                            HeightScreenEvent.OnHeightChange(
                                                currentHeight.toDouble()
                                            )
                                        )
                                        offsetY = event.y
                                    }

                                    true
                                }

                                else -> false
                            }
                        }
                        ,
                    contentScale = ContentScale.FillHeight
                )


                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(3.dp)
                        .offset(y = (offsetY / density).dp)
                        .align(Alignment.TopStart),
                    contentAlignment = Alignment.Center){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White, CircleShape)
                    )
                }
            }
        }

    }
}