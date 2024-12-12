package com.lingorise.app.screens.explorescreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.lingorise.app.core.spotlight.SpotlightPager
import kotlinx.coroutines.launch


@Composable
fun WatchScreen() {

//    val pagerState = rememberPagerState()
//    val videos by remember {
//        mutableStateOf(fakeWatchData())
//    }
//    val scope = rememberCoroutineScope()

//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            VerticalPager(
//                count = videos.size,
//                state = pagerState,
//                modifier = Modifier
//                    .weight(1f)
//
//            ) {
//                SpotlightPlayerView()
//            }
//        }
//        //ReelsScreen()
//
//
//
//    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        SpotlightPager()
    }
}




