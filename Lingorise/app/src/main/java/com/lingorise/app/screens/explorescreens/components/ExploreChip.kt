package com.lingorise.app.screens.explorescreens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lingorise.app.ui.theme.LingoriseYellow

fun chipData() = listOf(
    "Feed",
    "Watch"
)

@Composable
fun ExploreChip(
    chips: List<String> = chipData(),
    onClick: (Int) -> Unit
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chips.size) {
            Box(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .border(
                        border = BorderStroke(2.dp, LingoriseYellow),
                        shape = RoundedCornerShape(percent = 100)
                    )
                    .clip(RoundedCornerShape(percent = 100))
                    .background(
                        if (selectedChipIndex == it) LingoriseYellow
                        else Color.White
                    )
                    .clickable {
                        selectedChipIndex = it
                        onClick(selectedChipIndex)
                    }
            ) {

                Text(
                    text = chips[it],
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 6.dp)
                )

            }
        }
    }
}