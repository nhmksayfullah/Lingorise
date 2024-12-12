package com.lingorise.app.navigation.navgraphs


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lingorise.app.data.repository.fakedata.course1
import com.lingorise.app.navigation.screens.FullScreen

import com.lingorise.app.navigation.screens.RootScreen
import com.lingorise.app.screens.MainScreen
import com.lingorise.app.screens.coursescreens.EnrollCourseScreen
import com.lingorise.app.screens.splashscreen.SplashScreen



@Composable
fun SetupRootNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT_ROUTE,
        startDestination = FullScreen.SplashScreen.route
    ) {
        composable(
            route = FullScreen.SplashScreen.route
        ) {

            SplashScreen(navHostController = navHostController)

        }

        composable(
            route = Graph.BOTTOM_NAV_ROUTE
        ) {
            MainScreen()
        }


//        composable(
//            route = Graph.MR_LINGO_ROUTE
//        ) {
//            MrLingoScreen()
//        }

        authNavGraph(
            navHostController = navHostController
        )
    }
}