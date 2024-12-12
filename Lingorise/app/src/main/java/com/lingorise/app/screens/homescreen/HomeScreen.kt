package com.lingorise.app.screens.homescreen


import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.lingorise.app.core.corecomponents.sheets.CoreBottomSheetScreen
import com.lingorise.app.core.gamebox.quizer.ui.SampleCorrectSheetContent
import com.lingorise.app.data.repository.fakedata.*
import com.lingorise.app.domain.model.CourseData
import com.lingorise.app.domain.model.UserKey
import com.lingorise.app.domain.model.UserType
import com.lingorise.app.navigation.navgraphs.Graph
import com.lingorise.app.screens.homescreen.components.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    navHostController: NavHostController
) {


    val database = Firebase.database
    val courseRef = database.getReference("courses")
//    val courses = remember {
//        mutableStateListOf<CourseData>()
//    }
    val _lastName = FirebaseAuth.getInstance().currentUser?.displayName ?: "Hello Guest"
    var lastName = _lastName.substring(_lastName.lastIndexOf(" ").plus(1))

//    LaunchedEffect(key1 = true) {
//        courseRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                courses.clear()
//                snapshot.children.mapNotNullTo(courses) {
//                    it.getValue(CourseData::class.java)
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//        })
//    }


    val dataStore = StoreUserData(LocalContext.current)

    val userType = dataStore.readUserType.collectAsState(initial = "")


    //val scope = rememberCoroutineScope()


//    var openDialog by remember {
//        mutableStateOf(false)
//    }
//
//    if (openDialog) {
//        NoticeDialog(
//            dataStore = dataStore,
//            state = openDialog
//        ) {
//            openDialog = false
//        }
//    }


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center
    ) {

//        TryProBanner { onClick ->
//            if (onClick) {
//
//
//
//            }
//        }
        GreetingsBlock(name = lastName)

        Spacer(modifier = Modifier.height(20.dp))
//        CoursesBlock(
//            navHostController = navHostController,
//            courseList = fakeCourseList1()
//        ) {
//
//        }
        BlockArea(blocks = fakeCourseList1(), navHostController)

        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "More content coming soon",
            fontSize = 16.sp,
            color = Color.DarkGray,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Light
        )

//        SearchBar(
//            onClickDummy = {
//                if(it) {
//
//                }
//            }
//        ) { onClick ->
//            if (onClick) {
//
//
//            }
//
//        }

//        if (userType.value == UserKey().COURSE_ENROLLED) {
////            MyProgressBlock {
////
////            }
//
//            CurrentCoursesBlock(
//                courseData = fakeCurrentCourseList(),
//                navHostController = navHostController
//            ) {
//
//            }
//
//
//
//        }
//        if (userType.value == UserKey().FIRST_TIME) {
//            CoursesBlock(
//                navHostController = navHostController,
//                courseList = fakeCourseList1()
//            ) {
//
//            }
//        }




//        ShortTestButton { onClick ->
//            if (onClick) {
//
//
//            }
//
//        }

//        if (userType.value == UserKey().FIRST_TIME) {
//            NothingBlock()
//        }
    }
}

@Composable
fun NoticeDialog(
    dataStore: StoreUserData,
    state: Boolean,
    buttonText: String = "Back to Home",
    onDismiss: (Boolean) -> Unit
) {

    val scope = rememberCoroutineScope()
    if (state) {
        AlertDialog(
            onDismissRequest = {
                scope.launch {
                    dataStore.saveDialogState(false)
                    onDismiss(false)
                }
            },
            title = {
                Text(text = "Humble Notice")
            },
            text = {
                Text(text = "The app is under development. Some of the features are not available yet.")
            },
            buttons = {
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            scope.launch {
                                dataStore.saveDialogState(false)
                                onDismiss(false)
                            }

                        }
                    ) {
                        Text(buttonText)
                    }
                }
            })
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        navHostController = rememberNavController()
    )
}