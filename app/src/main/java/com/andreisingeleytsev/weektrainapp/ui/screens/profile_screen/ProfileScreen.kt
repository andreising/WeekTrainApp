package com.andreisingeleytsev.weektrainapp.ui.screens.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.andrei_singeleytsev.sportquizapp.presentation.utils.UIEvent
import com.andreisingeleytsev.weektrainapp.R
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor2

@Composable
fun ProfileScreen(
    paddingValues: PaddingValues,
    onNavigate: (String) -> Unit,
    viewModel: ProfileScreenViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
            when(uiEvent) {
                is UIEvent.Navigate ->{
                    onNavigate(uiEvent.route)
                }
                else ->{}
            }
        }
    }
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(MainColor),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(painter = painterResource(id = R.drawable.main_screen_bg), contentDescription = null,
        modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
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
                Text(
                    text = viewModel.user.value.name, style = TextStyle(
                        fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold
                    ), modifier = Modifier.padding(top = 20.dp)
                )
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Height", style = TextStyle(
                            fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold
                        )
                    )
                    Row(
                        modifier = Modifier.wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = viewModel.user.value.height.toString(), style = TextStyle(
                                fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        IconButton(onClick = { viewModel.onEvent(ProfileScreenEvent.OnHeightChange) }, modifier = Modifier.size(28.dp)) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_settings),
                                contentDescription = null,
                                tint = MainColor2,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Weight", style = TextStyle(
                            fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold
                        )
                    )
                    Row(
                        modifier = Modifier.wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = viewModel.user.value.weight.toString(), style = TextStyle(
                                fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        IconButton(onClick = { viewModel.onEvent(ProfileScreenEvent.OnWeightChange) }, modifier = Modifier.size(28.dp)) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_settings),
                                contentDescription = null,
                                tint = MainColor2,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Weight want?", style = TextStyle(
                            fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold
                        )
                    )
                    Row(
                        modifier = Modifier.wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = viewModel.user.value.wannaWeight.toString(), style = TextStyle(
                                fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        IconButton(onClick = { viewModel.onEvent(ProfileScreenEvent.OnWeightWantChange) }, modifier = Modifier.size(28.dp)) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_settings),
                                contentDescription = null,
                                tint = MainColor2,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }

            }
        }
    }
}