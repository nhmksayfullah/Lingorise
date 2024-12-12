package com.lingorise.app.screens.surveyscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lingorise.app.ui.theme.LingoriseYellow

@Composable
fun SurveyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(LingoriseYellow)
                .clip(RoundedCornerShape(
                    bottomStart = 4.dp,
                    bottomEnd = 4.dp
                )),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Survey")
                Text(
                    text = "Tell us about yourself to personalize your learning path",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }

        LanguageChip {

        }



    }
}


fun languageOptionData() = listOf(
    "বাংলা",
    "English"
)

@Composable
fun LanguageChip(
    chips: List<String> = languageOptionData(),
    onClick: (Int) -> Unit
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
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

@Preview
@Composable
fun SurveyScreenPreview() {
    SurveyScreen()
}