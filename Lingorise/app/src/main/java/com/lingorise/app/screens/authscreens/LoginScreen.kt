package com.lingorise.app.screens.authscreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
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
import com.google.firebase.ktx.Firebase
import com.lingorise.app.core.corecomponents.buttons.CoreFilledButton
import com.lingorise.app.core.corecomponents.texts.CoreEditText
import com.lingorise.app.domain.usecase.auth.clientId
import com.lingorise.app.domain.usecase.auth.rememberFirebaseAuthLauncher
import com.lingorise.app.navigation.navgraphs.Graph

@Composable
fun LoginScreen(navHostController: NavHostController) {


}
