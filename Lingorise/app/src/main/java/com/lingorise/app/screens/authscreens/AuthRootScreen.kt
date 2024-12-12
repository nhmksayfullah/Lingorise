package com.lingorise.app.screens.authscreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.lingorise.app.core.corecomponents.buttons.CoreFilledButton
import com.lingorise.app.core.corecomponents.texts.CoreEditText
import com.lingorise.app.domain.model.User
import com.lingorise.app.domain.usecase.auth.clientId
import com.lingorise.app.domain.usecase.auth.rememberFirebaseAuthLauncher
import com.lingorise.app.navigation.navgraphs.Graph
import com.lingorise.app.navigation.screens.AuthScreen
import com.lingorise.app.ui.theme.LingoriseYellow

@Composable
fun AuthRootScreen(
    navHostController: NavHostController
) {
    val database = Firebase.database.getReference("users")


    var user by remember {
        mutableStateOf(Firebase.auth.currentUser)
    }
    val launcher = rememberFirebaseAuthLauncher(
        onAuthComplete = {
            user = it.user
            val _lastName = user?.displayName ?: "Hello Guest"
            var lastName = _lastName.substring(_lastName.lastIndexOf(" ").plus(1))
            val _user = User(user?.uid, user?.displayName, user?.email, lastName)
            database.child(user?.uid ?: "Unknown ID").setValue(_user)
            navHostController.navigate(Graph.BOTTOM_NAV_ROUTE)
        }, onAuthError = {
            user = null
        })

    val token = clientId
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        GoogleButton(
            text = "Sign Up with Google",
            loadingText = "Creating Account...",
            onClicked = {
                val gso =
                    GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(token)
                        .requestEmail()
                        .build()
                val googleSignInClient = GoogleSignIn.getClient(context, gso)
                launcher.launch(googleSignInClient.signInIntent)
            }
        )


    }
}

