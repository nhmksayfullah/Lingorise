package com.lingorise.app.navigation.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.lingorise.app.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home: BottomBarScreen(
        route = RootScreen.HomeScreen.route,
        title = "Home",
        icon = R.drawable.icon_home
    )
    object Explore: BottomBarScreen(
        route = ExploreScreen.ExploreScreens.route,
        title = "Explore",
        icon = R.drawable.icon_explore
    )
    object Post: BottomBarScreen(
        route = ExploreScreen.ExploreScreens.route,
        title = "Post",
        icon = R.drawable.icon_filter
    )
    object Profile: BottomBarScreen(
        route = RootScreen.ProfileScreen.route,
        title = "Profile",
        icon = R.drawable.icon_profile
    )
    object More: BottomBarScreen(
        route = RootScreen.MoreScreen.route,
        title = "More",
        icon = R.drawable.icon_mic
    )
}

