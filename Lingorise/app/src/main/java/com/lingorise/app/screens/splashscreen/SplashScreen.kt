package com.lingorise.app.screens.splashscreen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lingorise.app.navigation.navgraphs.Graph
import com.lingorise.app.R
import com.lingorise.app.data.repository.fakedata.StoreUserData
import com.lingorise.app.domain.model.UserKey
import com.lingorise.app.ui.theme.LingoriseSkyBlue
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navHostController: NavHostController
) {
    val scale = remember {
        Animatable(0f)
    }
    val dataStore = StoreUserData(LocalContext.current)

    val userType = dataStore.readUserType.collectAsState(initial = "")

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.8f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(2000L)
        navHostController.popBackStack()
//        navHostController.navigate(Graph.BOTTOM_NAV_ROUTE)
        if(userType.value == UserKey().COURSE_ENROLLED) {
            navHostController.navigate(Graph.BOTTOM_NAV_ROUTE)
        } else {
            navHostController.navigate(Graph.AUTH_ROUTE)
        }
//        if(Firebase.auth.currentUser != null) {
//            navHostController.navigate(Graph.BOTTOM_NAV_ROUTE)
//        } else {
//            navHostController.navigate(Graph.AUTH_ROUTE)
//        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.lingorise_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .scale(scale.value)
        )
    }

}