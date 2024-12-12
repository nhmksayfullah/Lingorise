package com.lingorise.app.core.spotlight.blocks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lingorise.app.core.spotlight.ActionIcon
import com.lingorise.app.domain.model.SpotlightData


@Composable
fun SpotlightExtras(
    spotlightData: SpotlightData,
    onIconClicked: (ActionIcon) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Black.copy(.5f)
                        )
                    )
                )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.4f)
                .align(Alignment.BottomCenter)
        ) {
            SpotlightInfoBlock(spotlightData = spotlightData) {
                onIconClicked(it)
            }
        }
    }

}


@Composable
fun SpotlightInfoBlock(
    spotlightData: SpotlightData,
    onIconClicked: (ActionIcon) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(3f)
                .padding(bottom = 16.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            SpotlightBottomBlock(
                spotlightData = spotlightData,
                modifier = Modifier.fillMaxWidth(.76f)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(.5f),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpotlightButtonsColumn(spotlightData = spotlightData, onIconClicked = onIconClicked)
        }

    }
}



