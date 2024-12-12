package com.lingorise.app.navigation.navgraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.lingorise.app.R
import com.lingorise.app.data.repository.fakedata.course1
import com.lingorise.app.navigation.screens.CourseScreen
import com.lingorise.app.navigation.screens.ExploreScreen
import com.lingorise.app.navigation.screens.FullScreen
import com.lingorise.app.navigation.screens.RootScreen
import com.lingorise.app.screens.coursescreens.*
import com.lingorise.app.screens.explorescreens.ExploreScreen
import com.lingorise.app.screens.homescreen.HomeScreen
import com.lingorise.app.screens.morescreen.MoreScreen
import com.lingorise.app.screens.mrlingoscreen.MrLingoScreen
import com.lingorise.app.screens.profilescreens.ProfileScreen


@Composable
fun BottomNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = RootScreen.MainScreen.route,
        route = Graph.BOTTOM_NAV_ROUTE
    ) {

//        homeNavGraph(
//            navHostController = navHostController
//        )
        composable(
            route = RootScreen.MainScreen.route
        ) {
            HomeScreen(navHostController = navHostController)
        }

        composable(
            route = ExploreScreen.ExploreScreens.route
        ) {
            ExploreScreen(navHostController = navHostController)
        }

        composable(
            route = RootScreen.ProfileScreen.route
        ) {
            ProfileScreen(navHostController)
        }

        composable(
            route = RootScreen.MoreScreen.route
        ) {
            MoreScreen()
        }

//        composable(
//            route = Graph.FULL_SCREEN_ROUTE
//        ) {
//            FullScreenContainer()
//        }

        composable(
            route = CourseScreen.EnrollCourseScreen.route
        ) {
            EnrollCourseScreen(
                navHostController = navHostController,
                courseData = course1
            )
        }


        composable(
            route = FullScreen.MrLingoScreen.route
        ) {
            MrLingoScreen(
                navHostController = navHostController
            )
        }

        composable(
            route = CourseScreen.RunningCourseScreen.route
        ) {
            RunningCourseScreen(
                navHostController = navHostController
            )
        }

        composable(
            route = CourseScreen.CourseCompletedScreen.route
        ) {
            CourseCompletedScreen(
                R.drawable.lingorise_logo,
                navHostController
            )
        }
        composable(
            route = CourseScreen.EnrolledCourseScreen.route
        ) {
            EnrolledCourseScreen(
                navHostController,
                course1
            )
        }
        composable(
            route = CourseScreen.SelectFriendScreen.route
        ) {
            SelectFriendScreen(navHostController = navHostController)
        }

        //mrLingoGraph(navHostController = navHostController)

    }
}