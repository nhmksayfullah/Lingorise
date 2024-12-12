package com.lingorise.app.screens.coursescreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.lingorise.app.core.corecomponents.buttons.CoreFilledButton
import com.lingorise.app.data.repository.fakedata.StoreUserData
import com.lingorise.app.domain.model.CourseData
import com.lingorise.app.domain.model.UserKey
import com.lingorise.app.domain.model.UserType
import com.lingorise.app.domain.usecase.settings.EnrollmentMethod
import com.lingorise.app.navigation.screens.CourseScreen
import com.lingorise.app.navigation.screens.RootScreen
import com.lingorise.app.screens.homescreen.NoticeDialog
import com.lingorise.app.ui.theme.LingoriseRed
import com.lingorise.app.ui.theme.LingoriseSkyBlue
import com.lingorise.app.ui.theme.LingoriseYellow
import kotlinx.coroutines.launch

@Composable
fun EnrollCourseScreen(
    navHostController: NavHostController,
    courseData: CourseData
) {

    val dataStore = StoreUserData(LocalContext.current)
    val enrollmentMethod = EnrollmentMethod(LocalContext.current)

    val userType = dataStore.readUserType.collectAsState(initial = "")
    val scope = rememberCoroutineScope()


    var openDialog by remember {
        mutableStateOf(false)
    }

    if (openDialog) {
        NoticeDialog(
            dataStore = dataStore,
            state = openDialog,
            buttonText = "Close the Dialog"
        ) {
            openDialog = false
        }
    }




    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = courseData.thumbnail!!),
            contentDescription = courseData.shortDescription,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .border(BorderStroke(1.dp, Color.LightGray))
                .padding(16.dp),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = courseData.title!!,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "What will you learn",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = courseData.shortDescription!!,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Description",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = courseData.longDescription!!,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )

        }

    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Column {
//            CoreFilledButton(
//                label = "Enroll with your friend",
//                buttonColor = LingoriseSkyBlue,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp, vertical = 2.dp)
//            ) {
//                navHostController.navigate(CourseScreen.SelectFriendScreen.route)
//            }

//            Text(
//                text = "Learn and compete together!",
//                modifier = Modifier
//                .fillMaxWidth(),
//                textAlign = TextAlign.Center,
//            fontSize = 12.sp,
//            color = LingoriseRed)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                //horizontalArrangement = Arrangement.SpaceBetween
            ){
//                CoreFilledButton(
//                    label = "Try Pro",
//                    buttonColor = LingoriseSkyBlue,
//                    modifier = Modifier
//                        .fillMaxWidth(.5f)
//                ) {
//                    openDialog = true
//                }

//                Spacer(modifier = Modifier.width(4.dp))

                CoreFilledButton(
                    label = "Enroll Now",
                    buttonColor = LingoriseYellow,
                ) {
                    scope.launch {
                        dataStore.saveUserType(UserKey().COURSE_ENROLLED)
                    }
                    navHostController.popBackStack()
                    navHostController.navigate(CourseScreen.RunningCourseScreen.route)
                }
            }
        }

    }


}