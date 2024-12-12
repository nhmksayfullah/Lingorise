package com.lingorise.app.screens.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lingorise.app.domain.model.CourseData
import com.lingorise.app.ui.theme.LingoriseSkyBlue
import com.lingorise.app.R
import com.lingorise.app.core.chunkeycourse.Chunk
import com.lingorise.app.core.chunkeycourse.ChunkType
import com.lingorise.app.navigation.screens.CourseScreen
import com.lingorise.app.navigation.screens.FullScreen
import com.lingorise.app.navigation.screens.RootScreen
import kotlin.random.Random

@Composable
fun CoursesBlock(
    navHostController: NavHostController,
    courseList: List<CourseData>,
    onClick: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(
//                text = "Join Our Most Popular Courses!",
//                textAlign = TextAlign.Start,
//                color = Color.DarkGray,
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Bold
//            )
//
//            Text(
//                text = "See All",
//                textAlign = TextAlign.End,
//                color = LingoriseSkyBlue,
//                fontSize = 14.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier
//                    .clickable { onClick(true) }
//            )
//        }

//        Row {
//            LazyRow {
//                items(courseList.size) {
//                    CourseItem(
//                        navHostController = navHostController,
//                        image = courseList[it].thumbnail!!,
//                        title = courseList[it].title!!,
//                        isAvailable = courseList[it].id!!) {
//                        onClick(true)
//                    }
//                }
//
//            }
//        }
//        LazyColumn {
//            items(courseList.size) {
//                CourseItem(
//                    navHostController = navHostController,
//                    image = courseList[it].thumbnail!!,
//                    title = courseList[it].title!!,
//                    isAvailable = courseList[it].id!!,
//                    onClick
//                )
//            }
//        }
        courseList.forEach {
            CourseItem(
                navHostController = navHostController,
                image = it.thumbnail!!,
                title = it.title!!,
                isAvailable = it.id!!,
                onClick
            )
        }

    }
}





@Composable
fun CourseItem(
    navHostController: NavHostController,
    image: Int,
    title: String,
    isAvailable: Int,
    onClick: (Boolean) -> Unit
) {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
                if (isAvailable == 1) {
                    navHostController.navigate(CourseScreen.RunningCourseScreen.route)
                } else {
                    onClick(true)
                }
            },
        shape = MaterialTheme.shapes.small
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Nothing",
                    modifier = Modifier
                        .size(80.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
            }
        }
    }

}



//@Preview(showBackground = true)
//@Composable
//fun CoursesBlockPreview() {
//    CoursesBlock(fakeCourseList())
//}

@Preview(showBackground = true)
@Composable
fun CoursesItemPreview() {
    CourseItem(
        navHostController = rememberNavController(),
        image = R.drawable.icon_vocabulary,
        title = "Vocabulary",
        isAvailable = 1
    ) {

    }
}

@Composable
fun BlockArea(
    blocks: List<CourseData>,
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        blocks.forEach {
            if (it.chunks != null) {
                Text(
                    text = it.title ?: "Learn something more",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                ChunkBlock(chunks = it.chunks) {

                    navHostController.navigate(CourseScreen.RunningCourseScreen.route)
                }
                Spacer(modifier = Modifier
                    .height(4.dp)
                    .background(Color.LightGray))
            }
        }
    }
}


@Composable
fun ChunkBlock(
    chunks: List<Chunk>,
    onClick: (Chunk) -> Unit
) {


    Column {
        chunks.forEach {
            val paintings = if (it.chunkType == ChunkType.Video) R.drawable.video_icon else R.drawable.quiz_icon
            val padding = Random.nextInt(64, 256)

            Column(
                modifier = Modifier.fillMaxWidth().padding(start = padding.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = paintings),
                    contentDescription = it.index.toString(),
                    modifier = Modifier
                        .size(60.dp)
                        .clickable {
                            onClick(it)
                        }

                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = if (it.chunkType == ChunkType.Video) "Watch" else "Exercise")
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }

}