package com.lingorise.app.navigation.screens

sealed class FullScreen(val route: String) {

    object FullScreenContainer: FullScreen(route = "full_screen_container")
    object SplashScreen: FullScreen(route = "splash_screen")
    object MrLingoScreen: FullScreen(route = "mr_lingo_screen")
    object ShortTestScreen: FullScreen(route = "short_test_screen")

}
