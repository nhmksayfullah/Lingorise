package com.lingorise.app.core.corecomponents.progressbar

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lingorise.app.domain.model.ProgressData
import com.lingorise.app.ui.theme.LingoriseLightWhite
import com.lingorise.app.ui.theme.LingoriseYellow


@Composable
fun CoreHorizontalProgressBar(
    progressData: ProgressData,
    modifier: Modifier = Modifier,
    startAnimationDuration: Int = 1000,
    startAnimationDelay: Int = 200,
    backgroundColor: Color = LingoriseLightWhite,
    foregroundColor: Color = LingoriseYellow,
    easing: Easing = LinearOutSlowInEasing
) {

    var progressValue by remember {
        mutableStateOf(0f)
    }

    val size by animateFloatAsState(
        targetValue = progressValue,
        tween(
            durationMillis = startAnimationDuration,
            delayMillis = startAnimationDelay,
            easing = easing
        )
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
                .background(backgroundColor)
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(size)
                .clip(RoundedCornerShape(10.dp))
                .background(foregroundColor)
                .align(Alignment.TopStart)
                .animateContentSize()
        )
    }

    LaunchedEffect(key1 = true) {
        progressValue = progressData.value / progressData.outOf
    }


}

@Composable
fun HorizontalProgressBarDemo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CoreHorizontalProgressBar(
            progressData = ProgressData(4f, 9f, "Listening"),
            modifier = Modifier.weight(70f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "${30} % completed")
    }
}

@Preview(showBackground = true)
@Composable
fun HorizontalProgressBarDemoPreview() {
    HorizontalProgressBarDemo()
}