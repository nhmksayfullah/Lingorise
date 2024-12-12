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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lingorise.app.data.repository.fakedata.fakeProgressData
import com.lingorise.app.domain.model.ProgressData
import com.lingorise.app.ui.theme.LingoriseLightWhite
import com.lingorise.app.ui.theme.LingoriseSkyBlue


@Composable
fun CoreVerticalProgressBar(
    progressData: ProgressData,
    modifier: Modifier = Modifier,
    startAnimationDuration: Int = 1000,
    startAnimationDelay: Int = 200,
    height: Dp = 200.dp,
    width: Dp = 16.dp,
    easing: Easing = LinearOutSlowInEasing,
    backgroundColor: Color = LingoriseLightWhite,
    foregroundColor:Color = LingoriseSkyBlue
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

    Column(
        modifier = modifier
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .height(height)
                .width(width)
                .weight(70f)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
                    .background(backgroundColor)
            )

            Box(
                modifier = Modifier
                    .fillMaxHeight(size)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(foregroundColor)
                    .align(Alignment.BottomCenter)
                    .animateContentSize()
            )

        }

        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text = "${progressData.value}%",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = progressData.title,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )

    }


    LaunchedEffect(key1 = true) {
        progressValue = progressData.value / progressData.outOf
    }

}

@Composable
fun VerticalProgressBarDemo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        fakeProgressData().forEach {
            CoreVerticalProgressBar(progressData = ProgressData(it.value, it.outOf, it.title))
        }
    }


}

@Preview(showBackground = true)
@Composable
fun VerticalProgressBarPreview() {
    VerticalProgressBarDemo()
}
