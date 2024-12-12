package com.lingorise.app.screens.explorescreens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lingorise.app.domain.model.FeedPostData
import com.lingorise.app.R
import com.lingorise.app.data.repository.fakedata.StoreUserData
import com.lingorise.app.screens.homescreen.NoticeDialog
import com.lingorise.app.ui.theme.LingoriseLightRed
import com.lingorise.app.ui.theme.LingoriseRed

@Composable
fun FeedPost(feedPostData: FeedPostData) {

    val loveReact = if (feedPostData.isLiked) R.drawable.icon_love_filled else R.drawable.icon_love_outlined

    val dataStore = StoreUserData(LocalContext.current)
//    val dialogState = dataStore.readDialogState.collectAsState(initial = false)
    var openDialog by remember {
        mutableStateOf(false)
    }
    if (openDialog) {
        NoticeDialog(
            dataStore = dataStore,
            state = openDialog
        ) {
            openDialog = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(BorderStroke(0.5.dp, Color.LightGray), RoundedCornerShape(percent = 4))
            .padding(12.dp)
    ) {
        Text(
            text = feedPostData.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = feedPostData.content,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 5
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "read more",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                           openDialog = true
                },
            textAlign = TextAlign.End
        )
        Spacer(modifier = Modifier.height(8.dp))

        if (feedPostData.image != null) {
            Image(
                painter = painterResource(id = feedPostData.image),
                contentDescription = feedPostData.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(percent = 4)),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = loveReact),
                contentDescription = "love icon",
                tint = LingoriseRed,
                modifier = Modifier
                    .clickable {
                        openDialog = true
                    }
            )

            Spacer(modifier = Modifier.width(16.dp))

            Icon(
                painter = painterResource(id = R.drawable.icon_share),
                contentDescription = "share icon",
                modifier = Modifier
                    .clickable {
                        openDialog = true
                    }
            )
        }

    }

}

