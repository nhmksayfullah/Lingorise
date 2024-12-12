@file:UnstableApi

package com.lingorise.app.core.spotlight
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.media3.common.util.UnstableApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.lingorise.app.core.spotlight.blocks.SpotlightExtras
import com.lingorise.app.core.spotlight.blocks.SpotlightView
import com.lingorise.app.data.repository.fakedata.fakeSpotlight
import com.lingorise.app.domain.model.SpotlightData
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlin.math.abs



@OptIn(ExperimentalPagerApi::class)
@Composable
fun SpotlightPager(
    spotlights: List<SpotlightData> = fakeSpotlight
) {

    val pagerState = rememberPagerState()

    var isPaused by remember {
        mutableStateOf(false)
    }

    val isFirstItem by remember {
        derivedStateOf {
            pagerState.currentPage == 0
        }
    }

    LaunchedEffect(key1 = pagerState) {
        snapshotFlow { pagerState.currentPage }.distinctUntilChanged().collect { page ->
            pagerState.animateScrollToPage(page)
        }
    }


    Box {
        VerticalPager(
            count = spotlights.size,
            state = pagerState,
            horizontalAlignment = Alignment.CenterHorizontally,
            itemSpacing = 10.dp
        ) { index ->

            val shouldPlay by remember(pagerState) {
                derivedStateOf {
                    (abs(currentPageOffset) < .5 && currentPage == index)
                            || (abs(currentPageOffset) > .5 && pagerState.currentPage == index)
                }
            }

            SpotlightView(
                spotlightData = spotlights[index],
                isPaused = isPaused,
                onPaused = {
                           isPaused = it
                },
                shouldPlay = shouldPlay,
                isScrolling = pagerState.isScrollInProgress
            )

            SpotlightExtras(spotlightData = fakeSpotlight[index], onIconClicked = { icon ->

                when (icon) {
                    ActionIcon.CAMERA -> {
                        //:TODO
                    }
                    ActionIcon.SHARE -> {
                        //:TODO
                    }
                    ActionIcon.MORE_OPTIONS -> {
                        //:TODO
                    }
                    ActionIcon.AUDIO -> {
                        //:TODO
                    }
                    ActionIcon.LIKE -> {
//                        onLiked(index, !reels[index].reelInfo.isLiked)
                    }
                    ActionIcon.COMMENT -> {
                        //:TODO
                    }
                }

            })

        }
    }


}





