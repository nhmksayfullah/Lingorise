package com.lingorise.app.screens.coursescreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.lingorise.app.R
import com.lingorise.app.core.corecomponents.buttons.CoreFilledButton
import com.lingorise.app.core.corecomponents.progressbar.CoreHorizontalProgressBar
import com.lingorise.app.data.repository.fakedata.course1
import com.lingorise.app.domain.model.CourseData
import com.lingorise.app.domain.usecase.settings.EnrollmentMethod
import com.lingorise.app.navigation.screens.CourseScreen

@Composable
fun EnrolledCourseScreen(
    navHostController: NavHostController,
    courseData: CourseData
) {
    val database = Firebase.database
    val enrollmentRef = database.getReference("enrollment")
    val context = LocalContext.current
    val enrollmentMethod = EnrollmentMethod(context)
    val isMultiPlayer = enrollmentMethod.isMultiple.collectAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Card(
            elevation = 10.dp,
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Text(
                    text = courseData.title!!,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))
                if (isMultiPlayer.value == false) {
                    HeadProgressBar(courseData = courseData)
                } else {
                    Row {
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.user1),
                                contentDescription = "nothing",
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )
                            Text(
                                text = "Myself",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                        HeadProgressBar(courseData = courseData)

                    }
                    Row {
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.user2),
                                contentDescription = "nothing",
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )
                            Text(
                                text = "M Salah",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                        HeadProgressBar(courseData = courseData)

                    }

                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        CoreFilledButton(label = "Start The Course") {
            navHostController.navigate(CourseScreen.RunningCourseScreen.route)
        }



    }

}


@Composable
fun HeadProgressBar(
    courseData: CourseData
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {

        CoreHorizontalProgressBar(
            progressData = courseData.progressData!!
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "${courseData.progressData.value}% completed",
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.End
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun EnrolledCourseScreenPreview() {
    Box {
        EnrolledCourseScreen(navHostController = rememberNavController(), courseData = course1)
    }
}