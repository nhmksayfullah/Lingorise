package com.lingorise.app.navigation.screens

sealed class AuthScreen(val route: String) {
    object AuthRootScreen: AuthScreen(route = "login_signup_screen")
    object LoginScreen: AuthScreen(route = "login_screen")
    object SignupScreen: AuthScreen(route = "signup_screen")
    object BDAppsPhoneScreen: AuthScreen(route = "bdapps_phone")
    object BDAppsOTPScreen: AuthScreen(route = "bdapps_otp")
}
