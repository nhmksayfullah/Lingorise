package com.lingorise.app.screens.profilescreens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lingorise.app.R

@Composable
fun MyFriendsBlock() {
    val friendsImage = listOf<Int>(
        R.drawable.lingorise_logo,
        R.drawable.lingorise_logo,
        R.drawable.lingorise_logo,
        R.drawable.lingorise_logo,
        R.drawable.lingorise_logo
    )
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "My Friends",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Text(
            text = "See all friends",
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        )
    }

    Spacer(modifier = Modifier.height(8.dp))

    LazyRow{
        items(friendsImage) {
            Image(
                painter = painterResource(id = it),
                contentDescription = "my friend",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(percent = 20))
                    .padding(start = 16.dp)
            )
        }
    }
}