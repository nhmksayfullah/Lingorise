package com.lingorise.app.screens.coursescreens

import android.text.Selection
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.RadioButton
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.Role.Companion.Switch
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.lingorise.app.domain.model.User
import com.lingorise.app.R
import com.lingorise.app.core.corecomponents.buttons.CoreFilledButton
import com.lingorise.app.data.repository.fakedata.StoreUserData
import com.lingorise.app.domain.model.CourseEnroll
import com.lingorise.app.domain.model.UserKey
import com.lingorise.app.domain.usecase.settings.EnrollmentMethod
import com.lingorise.app.navigation.screens.CourseScreen
import com.lingorise.app.navigation.screens.RootScreen
import com.lingorise.app.ui.theme.LingoriseLightWhite
import com.lingorise.app.ui.theme.LingoriseYellow
import kotlinx.coroutines.launch


@Composable
fun SelectFriendScreen(navHostController: NavHostController) {
    val currentUser = FirebaseAuth.getInstance().currentUser
    val database = Firebase.database
    val userRef = database.getReference("users")
    val enrollmentRef = database.getReference("enrollment")
    val context = LocalContext.current
    val enrollmentMethod = EnrollmentMethod(context)
    val scope = rememberCoroutineScope()
    val users = remember {
        mutableStateListOf<User>()
    }
    val (selected, onSelected) = remember {
        mutableStateOf(User())
    }
    val dataStore = StoreUserData(LocalContext.current)


    LaunchedEffect(key1 = true) {
        userRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                users.clear()
                snapshot.children.mapNotNullTo(users){

                    it.getValue(User::class.java)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .selectableGroup()
    ) {
        users.forEach { user ->
            if (user.userId != currentUser?.uid) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(60.dp)
                        .background(if (user == selected) LingoriseYellow else LingoriseLightWhite)
                        .clip(RoundedCornerShape(16.dp))
                        .selectable(
                            selected = (user == selected),
                            onClick = { onSelected(user) },
                            role = Role.RadioButton
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user1),
                        contentDescription = "user profile demo"
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    if (user.lastName != null) {
                        Text(
                            text = user.lastName,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    } else if (user.userName != null) {
                        Text(
                            text = user.userName,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }

        // other
        CoreFilledButton(label = "Enroll") {
            val enrollment = CourseEnroll(
                userId = currentUser!!.uid,
                opponentId = selected.userId,
                userProgress = 0.0,
                opponentProgress = 0.0,
                isUserActive = true,
                isOpponentActive = false
            )
            enrollmentRef.child(currentUser.uid).setValue(enrollment)
            scope.launch {
                enrollmentMethod.enroll(true)
                dataStore.saveUserType(UserKey().COURSE_ENROLLED)
            }
//            navHostController.popBackStack(
//                route = CourseScreen.EnrolledCourseScreen.route,
//                inclusive = true
//            )
            navHostController.popBackStack(
                route = RootScreen.HomeScreen.route,
                inclusive = true
            )
            navHostController.navigate(CourseScreen.EnrolledCourseScreen.route)
        }

    }
}



@Preview
@Composable
fun SelectFriendScreenPreview() {
//    SelectFriendScreen()
//    SelectFriend()
}