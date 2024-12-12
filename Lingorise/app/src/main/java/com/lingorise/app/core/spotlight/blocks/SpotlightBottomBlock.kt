package com.lingorise.app.core.spotlight.blocks

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.lingorise.app.domain.model.SpotlightData


@Composable
fun SpotlightBottomBlock(
    spotlightData: SpotlightData,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val interactionSource = remember { MutableInteractionSource() }
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        spotlightData.title.let { desc ->
            Text(
                text = desc,
                fontSize = 14.sp,
                maxLines = 2,
                color = Color.White,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .animateContentSize()
            )
        }
    }

}
