package com.lingorise.app.screens.homescreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lingorise.app.core.corecomponents.progressbar.CoreCircularProgressBar
import com.lingorise.app.core.corecomponents.progressbar.CoreVerticalProgressBar
import com.lingorise.app.domain.model.ProgressData
import com.lingorise.app.data.repository.fakedata.fakeProgressData
import com.lingorise.app.ui.theme.LingoriseSkyBlue

@Composable
fun MyProgressBlock(
    onClick: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { onClick(true) },
        shape = MaterialTheme.shapes.medium,
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "My Progress",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
                Text(
                    text = "See Details Inside →",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = LingoriseSkyBlue
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                VerticalProgressBarHome(progressData = fakeProgressData())
                CircularProgressBarHome(
                    progressData = ProgressData(
                        5f,
                        9f,
                        "Predicted IELTS Score"
                    )
                )
            }

        }
    }
}

@Composable
fun VerticalProgressBarHome(progressData: List<ProgressData>) {
    Row(
        modifier = Modifier
            .height(200.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        progressData.forEach { data ->
            CoreVerticalProgressBar(
                progressData = ProgressData(data.value, data.outOf, data.title, data.color),
                modifier = Modifier
                    .padding(end = 8.dp),
                foregroundColor = data.color
            )
        }
    }
}

@Composable
fun CircularProgressBarHome(progressData: ProgressData) {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        CoreCircularProgressBar(
            progressData = progressData,
            radius = 36.dp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = progressData.title,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
    }


}


@Preview(showBackground = true)
@Composable
fun MyProgressBlockPreview() {
    MyProgressBlock {

    }
}