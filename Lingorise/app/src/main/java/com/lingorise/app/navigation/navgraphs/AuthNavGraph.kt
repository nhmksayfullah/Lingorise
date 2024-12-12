package com.lingorise.app.navigation.navgraphs

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.lingorise.app.navigation.screens.AuthScreen
import com.lingorise.app.screens.authscreens.*

fun NavGraphBuilder.authNavGraph(
    navHostController: NavHostController
) {
    navigation(
        route = Graph.AUTH_ROUTE,
        startDestination = AuthScreen.BDAppsPhoneScreen.route
    ) {

        composable(
            route = AuthScreen.AuthRootScreen.route
        ) {
            AuthRootScreen(navHostController = navHostController)
        }
        composable(
            route = AuthScreen.SignupScreen.route
        ) {
            SignupScreen(navHostController = navHostController)
        }
        composable(
            route = AuthScreen.LoginScreen.route
        ) {
            LoginScreen(navHostController = navHostController)
        }

        composable(route = AuthScreen.BDAppsPhoneScreen.route) {
            BDAppsPhoneScreen(navHostController = navHostController)
        }
        composable(
            route = "${AuthScreen.BDAppsOTPScreen.route}/{ref}",
            arguments = listOf(navArgument("ref") {
                type = NavType.StringType
            })
        ) {
            BDAppsOTPScreen(
                navHostController = navHostController,
                it.arguments?.getString("ref") ?: "failed"
            )
        }

    }
}