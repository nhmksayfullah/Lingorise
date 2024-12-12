package com.lingorise.app.screens.explorescreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lingorise.app.data.repository.fakedata.fakeFeedData
import com.lingorise.app.screens.explorescreens.components.FeedPost

@Composable
fun FeedScreen() {

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            ) {
            LazyColumn {
                items(fakeFeedData().size) {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        FeedPost(feedPostData = fakeFeedData()[it])
                    }
                }
            }
        }
    }

}