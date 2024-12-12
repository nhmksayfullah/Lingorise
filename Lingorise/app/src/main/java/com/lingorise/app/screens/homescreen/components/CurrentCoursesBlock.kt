package com.lingorise.app.screens.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.lingorise.app.core.corecomponents.progressbar.CoreHorizontalProgressBar
import com.lingorise.app.domain.model.CourseData
import com.lingorise.app.navigation.screens.CourseScreen
import com.lingorise.app.ui.theme.LingoriseLightWhite
import com.lingorise.app.ui.theme.LingoriseSkyBlue

@Composable
fun CurrentCourse(
    courseData: CourseData,
    navHostController: NavHostController
) {
    Card(
        elevation = 5.dp,
        modifier = Modifier
            .padding(start = 8.dp, top = 16.dp, bottom = 16.dp, end = 8.dp)
            .wrapContentHeight()
            .fillMaxWidth(.9f)
            .clickable {
                navHostController.navigate(CourseScreen.RunningCourseScreen.route)
            }
    ) {
        Row {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .background(LingoriseLightWhite)
                    .clip(RoundedCornerShape(4.dp))
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = courseData.thumbnail!!),
                    contentDescription = courseData.title,
                    modifier = Modifier
                        .size(70.dp)
                )
            }

            Column(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = courseData.title!!,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Today's Words:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = courseData.shortDescription!!,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    CoreHorizontalProgressBar(
                        progressData = courseData.progressData!!,
                        modifier = Modifier
                            .height(10.dp)
                            .width(80.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${courseData.progressData.value*10}% Completed",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.End
                    )
                }
            }

        }
    }

}



@Composable
fun CurrentCoursesBlock(
    courseData: List<CourseData>,
    navHostController: NavHostController,
    onClick: (Boolean) -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "My Current Block",
                textAlign = TextAlign.Start,
                color = Color.DarkGray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "See All",
                textAlign = TextAlign.End,
                color = LingoriseSkyBlue,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable { onClick(true) }
            )
        }

        Row {
            LazyRow {

                items(courseData.size) {
                    CurrentCourse(
                        courseData = courseData[it],
                        navHostController = navHostController
                    )
                }

            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun CurrentCourseBlockPreview() {
//    CurrentCoursesBlock(courseData = fakeCourseList())
}