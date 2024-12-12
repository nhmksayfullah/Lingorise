package com.lingorise.app.navigation.screens

sealed class ExploreScreen(val route: String) {
    object ExploreScreens: ExploreScreen(route = "explore_screens")
    object FeedScreen: ExploreScreen(route = "feed_screen")
    object WatchScreen: ExploreScreen(route = "watch_screen")
}