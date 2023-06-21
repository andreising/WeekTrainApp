package com.andrei_singeleytsev.sportquizapp.presentation.menu

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor
import com.andreisingeleytsev.weektrainapp.ui.theme.MainColor2


@Composable
fun BottomNavigationMenu(currentRoute: String?,onNavigate: (String)->Unit) {
    val listItems = listOf(
        BottomNavigationItem.ProfileItem,
        BottomNavigationItem.TrainingItem,
        BottomNavigationItem.StatisticItem
    )
    BottomAppBar(
        containerColor = MainColor
    ) {
        listItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute==item.route,
                onClick = {
                          onNavigate(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon_id),
                        contentDescription = "bottom_icon"
                    )
                },
                label = {
                    Text(text = item.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MainColor2,
                    selectedTextColor = MainColor2,
                    unselectedIconColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = MainColor
                )
            )

        }
    }
}