package com.lingorise.app.screens.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lingorise.app.R
import com.lingorise.app.navigation.navgraphs.Graph
import com.lingorise.app.navigation.screens.FullScreen
import com.lingorise.app.navigation.screens.RootScreen

@Composable
fun MrLingoFloating(
    navHostController: NavHostController
) {
    FloatingActionButton(
        onClick = {
            navHostController.navigate(FullScreen.MrLingoScreen.route)
        },
        backgroundColor = Color.White,
        shape = CircleShape
    ) {
        Image(
            painter = painterResource(id = R.drawable.mr_lingo_face),
            contentDescription = "Mr Lingo Floating Button",
            modifier = Modifier
                .size(60.dp)
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MrLingoFloatingPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        MrLingoFloating(rememberNavController())
    }
}