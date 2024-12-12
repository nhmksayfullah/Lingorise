package com.lingorise.app.core.pager

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.flow.distinctUntilChanged


@OptIn(ExperimentalPagerApi::class)
@Composable
fun CoreVerticalPager(
    pagerCount: Int,
    itemSpacing: Dp = 10.dp,
    content: @Composable (PagerState, Float, Int) -> Unit
) {

    val pagerState = rememberPagerState()

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
            count = pagerCount,
            state = pagerState,
            horizontalAlignment = Alignment.CenterHorizontally,
            itemSpacing = itemSpacing
        ) { index ->

            content(pagerState, currentPageOffset, index)

        }
    }

}