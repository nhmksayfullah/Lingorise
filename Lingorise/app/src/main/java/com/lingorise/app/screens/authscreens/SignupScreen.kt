package com.lingorise.app.screens.authscreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lingorise.app.core.corecomponents.buttons.CoreFilledButton
import com.lingorise.app.core.corecomponents.texts.CoreEditText
import com.lingorise.app.domain.usecase.auth.AuthProvider
import com.lingorise.app.navigation.navgraphs.Graph

@Composable
fun SignupScreen(
    navHostController: NavHostController
) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }


    Column {
        OutlinedTextField(
            value = email,
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
                .wrapContentHeight(),
            onValueChange = {
            email = it
        },
            placeholder = {
                Text(text = "Email")
            }
        )
        OutlinedTextField(
            value = password,
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
                .wrapContentHeight(),
            onValueChange = {
            password = it
        },
            placeholder = {
                Text(text = "Password")
            }
        )
        CoreFilledButton(label = "SignUp") {
            AuthProvider.signUp(email, password) {
                navHostController.navigate(Graph.BOTTOM_NAV_ROUTE)
            }
        }
    }

//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = "SignUp",
//            fontSize = 40.sp,
//            modifier = Modifier.clickable {
//                navHostController.navigate(Graph.BOTTOM_NAV_ROUTE)
//            }
//        )
//
//
//    }
}