package com.lingorise.app.navigation.screens



sealed class RootScreen(val route: String) {
    object MainScreen: RootScreen(route = "home_screen")
    object HomeScreen : RootScreen(route = "home_screen")
    object ProfileScreen: RootScreen(route = "profile_screen")
    object MoreScreen: RootScreen(route = "more_screen")

}
