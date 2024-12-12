package com.lingorise.app.screens.explorescreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.lingorise.app.navigation.screens.ExploreScreen
import com.lingorise.app.screens.explorescreens.components.ExploreChip

@Composable
fun ExploreScreen(
    navHostController: NavHostController
) {
    var currentScreen by remember {
        mutableStateOf(ExploreScreen.FeedScreen.route)
    }

    Box(
        Modifier
            .fillMaxSize()
    ) {

        Column {
            ExploreChip {
                currentScreen = if(it == 0) {
                    ExploreScreen.FeedScreen.route
                } else {
                    ExploreScreen.WatchScreen.route
                }
            }

            if(currentScreen == ExploreScreen.FeedScreen.route) {
                FeedScreen()
            } else {
                WatchScreen()
            }
        }
    }


}