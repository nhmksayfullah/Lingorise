package com.lingorise.app.core.gamebox.quizer.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lingorise.app.core.corecomponents.buttons.CoreFilledButton
import com.lingorise.app.ui.theme.LingoriseRed
import com.lingorise.app.ui.theme.LingoriseSkyBlue
import com.lingorise.app.ui.theme.LingoriseYellow

@Composable
fun SampleCorrectSheetContent(
    modifier: Modifier = Modifier,
    bodyLabel: String = "Wow, Great!!",
    buttonLabel: String = "Continue",
    onClick: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 16.dp)
        ) {
            Text(
                text = bodyLabel,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            CoreFilledButton(
                label = buttonLabel,
                buttonColor = LingoriseYellow
            ) {
                onClick()
            }
        }
    }
}
@Composable
fun SampleWrongSheetContent(
    modifier: Modifier = Modifier,
    bodyLabel: String = "Oh no! I just missed it",
    buttonLabel: String = "Try Again",
    onClick: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 16.dp)
        ) {
            Text(
                text = bodyLabel,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            CoreFilledButton(
                label = buttonLabel,
                buttonColor = LingoriseRed
            ) {
                onClick()
            }
        }
    }
}

@Composable
fun SampleNotSelectedSheetContent(
    modifier: Modifier = Modifier,
    bodyLabel: String = "Please select any option",
    buttonLabel: String = "Try Again",
    onClick: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 16.dp)
        ) {
            Text(
                text = bodyLabel,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            CoreFilledButton(
                label = buttonLabel,
                buttonColor = LingoriseSkyBlue
            ) {
                onClick()
            }
        }
    }
}

@Preview
@Composable
fun SheetContentPreview() {
    SampleCorrectSheetContent {

    }
}