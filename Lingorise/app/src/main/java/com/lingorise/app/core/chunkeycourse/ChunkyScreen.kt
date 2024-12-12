package com.lingorise.app.core.chunkeycourse

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.lingorise.app.core.corecomponents.buttons.CoreFilledButton
import com.lingorise.app.core.gamebox.quizer.model.Quiz
import com.lingorise.app.core.gamebox.quizer.ui.QuizScreen
import com.lingorise.app.core.spotlight.blocks.SpotlightView
import com.lingorise.app.data.repository.fakedata.fakeChunks
import com.lingorise.app.domain.model.SpotlightData
import com.lingorise.app.ui.theme.LingoriseLightWhite
import com.lingorise.app.ui.theme.LingoriseLightYellow
import com.lingorise.app.ui.theme.LingoriseYellow
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ChunkyScreen(
    chunks: List<Chunk>,
    onCompleted: (Boolean) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val pagerState = rememberPagerState()
        val scope = rememberCoroutineScope()
        var completed by remember {
            mutableStateOf(false)
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = LingoriseYellow,
            inactiveColor = LingoriseLightWhite,
            indicatorWidth = 40.dp,
            indicatorHeight = 10.dp,
            spacing = 8.dp,
            indicatorShape = RoundedCornerShape(percent = 100)
        )

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalPager(
            count = chunks.size,
            state = pagerState,
            modifier = Modifier.weight(1f),
            userScrollEnabled = false
        ) { currentPage ->

            Column {

                if (chunks[currentPage].chunkType == ChunkType.Quiz) {

                    QuizScreen(chunks[currentPage].chunk as Quiz) {

                        scope.launch {
                            if (currentPage < chunks.size - 1) {
                                pagerState.animateScrollToPage(page = currentPage + 1)
                            } else {
                                completed = true
                                Log.d("is completed", "completed")
                            }
                            onCompleted(completed)
                        }


                    }

                } else if (chunks[currentPage].chunkType == ChunkType.Video) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(40.dp))
                        SpotlightView(
                            modifier = Modifier
                                .fillMaxHeight(.8f),
                            spotlightData = chunks[currentPage].chunk as SpotlightData,
                            isPaused = false,
                            onPaused = { },
                            shouldPlay = true,
                            isScrolling = false
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {

                            Spacer(modifier = Modifier.height(16.dp))
                            CoreFilledButton(label = "Continue", buttonColor = LingoriseYellow) {

                                scope.launch {
                                    if (currentPage < chunks.size - 1) {
                                        pagerState.animateScrollToPage(page = currentPage + 1)
                                    } else {
                                        completed = true

                                    }
                                    onCompleted(completed)
                                }

                            }
                        }

                    }
                }

            }

        }

    }

}

@Preview
@Composable
fun ChunkyCourseScreenPreview() {
    ChunkyScreen(chunks = fakeChunks) {

    }
}