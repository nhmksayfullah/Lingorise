package com.lingorise.app.screens.mrlingoscreen.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import com.lingorise.app.R
import com.lingorise.app.screens.homescreen.components.SearchBar

@Composable
fun MrLingoBottomBar() {
    SearchBar(
        placeHolder = "Massage",
        icon = R.drawable.icon_mic,
        buttonShape = CircleShape,
        onClickDummy = {

        }
    ) {

    }
}