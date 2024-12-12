package com.lingorise.app.screens.profilescreens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lingorise.app.ui.theme.LingoriseRed
import com.lingorise.app.ui.theme.LingoriseYellow

@Composable
fun ActionButton() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(percent = 20),
            colors = ButtonDefaults.buttonColors(LingoriseYellow),
            modifier = Modifier
                .height(50.dp)
        ) {
            Text(
                text = "Finished Courses",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            )
        }
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(percent = 20),
            colors = ButtonDefaults.buttonColors(LingoriseRed),
            modifier = Modifier
                .height(50.dp)
        ) {
            Text(
                text = "Earned Badges",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            )
        }

    }
}