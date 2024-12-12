package com.lingorise.app.screens.coursescreens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.lingorise.app.core.chunkeycourse.Chunk
import com.lingorise.app.core.chunkeycourse.ChunkyScreen
import com.lingorise.app.data.repository.fakedata.fakeChunks
import com.lingorise.app.navigation.screens.CourseScreen

@OptIn(ExperimentalPagerApi::class)
@Composable
fun RunningCourseScreen(
    navHostController: NavHostController,
    chunks: List<Chunk> = fakeChunks
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        ChunkyScreen(chunks = chunks) { completed ->
            if (completed) {
                navHostController.popBackStack()
            }
        }
    }

}


@Preview
@Composable
fun CourseScreenPreview() {
    RunningCourseScreen(navHostController = rememberNavController())
}