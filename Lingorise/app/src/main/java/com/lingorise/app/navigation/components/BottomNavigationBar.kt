package com.lingorise.app.navigation.components


import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.lingorise.app.navigation.screens.BottomBarScreen


@Composable
fun BottomNavigationBar(
    navHostController: NavHostController,
    screens: List<BottomBarScreen>,
    currentDestination:  NavDestination?

) {
//    val screens = listOf(
//        BottomBarScreen.Home,
//        BottomBarScreen.Explore,
//        BottomBarScreen.Profile,
//        BottomBarScreen.More
//    )
//
//    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
//    val currentDestination = navBackStackEntry?.destination
//
//    val bottomDestination = screens.any {
//        it.route == currentDestination?.route
//    }

    BottomNavigation(
            backgroundColor = MaterialTheme.colors.background
        ) {
            screens.forEach {screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navHostController = navHostController
                )
            }
        }


}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(
                text = screen.title
            )
        },
        icon = {
            Icon(painter = painterResource(id = screen.icon), contentDescription = screen.title)
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navHostController.navigate(screen.route) {
                popUpTo(navHostController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        alwaysShowLabel = false
    )

}