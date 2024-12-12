package com.lingorise.app.core.constants

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val defaultButtonModifier = Modifier
    .fillMaxWidth()
    .height(40.dp)

val defaultImageModifier = Modifier
    .fillMaxWidth()
    .wrapContentHeight()

val defaultEditTextModifier = Modifier
    .height(50.dp)
    .border(BorderStroke(1.dp, defaultButtonOutlineColor), RoundedCornerShape(percent = 16))
    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
    .background(color = Color.White)

val defaultCardModifier = Modifier
    .fillMaxWidth()
    .height(200.dp)
    .padding(end = 16.dp, top = 4.dp, bottom = 4.dp)

//val defaultElevationFloatingActionButton = FloatingActionButtonDefaults.elevation(10.dp)