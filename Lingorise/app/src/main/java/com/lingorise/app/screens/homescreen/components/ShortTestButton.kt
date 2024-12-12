package com.lingorise.app.screens.homescreen.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lingorise.app.R
import com.lingorise.app.ui.theme.LingoriseLightWhite

@Composable
fun ShortTestButton(
    onClick: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
            .clickable { onClick(true) },
        shape = MaterialTheme.shapes.small,
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(percent = 8))
                    .background(LingoriseLightWhite)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_exam),
                    contentDescription = "Test Icon",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Take A Short Test To Personalize Your Learning Path!!",
                color = Color.DarkGray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShortTestButtonPreview() {
    ShortTestButton {

    }
}