package com.lingorise.app.core.corecomponents.progressbar

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lingorise.app.domain.model.ProgressData
import com.lingorise.app.ui.theme.LingoriseLightWhite
import com.lingorise.app.ui.theme.LingoriseSkyBlue
import com.lingorise.app.ui.theme.Purple200
import com.lingorise.app.ui.theme.Purple700

@Composable
fun CircularProgressBar(
    progressData: ProgressData,
    modifier: Modifier = Modifier,
    startAnimationDuration: Int = 1000,
    startAnimationDelay: Int = 200,
    circleColor: Color = Purple700,
    backgroundColor: Color = Purple200,
    width: Dp = 16.dp,
    size: Dp = 80.dp
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val percentage by animateFloatAsState(
        targetValue = if (animationPlayed) (progressData.value/progressData.outOf) else 0f,
        animationSpec = tween(
            durationMillis = startAnimationDuration,
            delayMillis = startAnimationDelay
        )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            progress = 1f,
            color = backgroundColor,
            strokeWidth = width,
            modifier = Modifier
                .size(size)
        )

        CircularProgressIndicator(
            progress = percentage,
            color = circleColor,
            strokeWidth = width,
            modifier = Modifier
                .size(size)
        )

        Text(
            text = "${progressData.value}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )

    }
}


@Composable
fun CoreCircularProgressBar(
    progressData: ProgressData,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    modifier: Modifier = Modifier.size(radius * 2f),
    foregroundColor: Color = LingoriseSkyBlue,
    backgroundColor: Color = LingoriseLightWhite,
    strokeWidth: Dp = 16.dp,
    startAnimationDuration: Int = 1000,
    startAnimationDelay: Int = 200,
    insideContent: @Composable () -> Unit = {
    }
) {

    var animationPlayed by remember {
        mutableStateOf(false)
    }

    val percentage by animateFloatAsState(
        targetValue = if (animationPlayed) (progressData.value/progressData.outOf) else 0f,
        animationSpec = tween(
            durationMillis = startAnimationDuration,
            delayMillis = startAnimationDelay
        )
    )

    LaunchedEffect(key1 = true) { animationPlayed = true }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        Canvas(modifier = Modifier.size(radius * 2f)) {

            drawCircle(
                color = backgroundColor,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )

            drawArc(
                color = foregroundColor,
                0f,
                360 * percentage,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )

        }

        Text(
            text = "${progressData.value}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )

    }

}


@Preview
@Composable
fun CircularProgressBarPreview() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        CoreCircularProgressBar(progressData = ProgressData(4.5f,9f, "Listening"))
        CircularProgressBar(progressData = ProgressData(5f,9f, "Listening"))
    }
}