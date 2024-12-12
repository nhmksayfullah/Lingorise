package com.lingorise.app.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lingorise.app.data.repository.fakedata.StoreUserData
import com.lingorise.app.navigation.components.BottomNavigationBar
import com.lingorise.app.navigation.navgraphs.BottomNavGraph
import com.lingorise.app.navigation.screens.BottomBarScreen
import com.lingorise.app.navigation.screens.RootScreen
import com.lingorise.app.screens.homescreen.components.MrLingoFloating


@Composable
fun MainScreen(
    navHostController: NavHostController = rememberNavController()
) {

//    val scope = rememberCoroutineScope()
//    val snackbarHostState = remember {
//        SnackbarHostState()
//    }

//    val dataStore = StoreUserData(LocalContext.current)
//    val dialogState = dataStore.readDialogState.collectAsState(initial = false)
//    var openDialog by remember {
//        mutableStateOf(true)
//    }
//    if (openDialog) {
//        NoticeDialog(
//            dataStore = dataStore,
//            state = openDialog
//        ) {
//            openDialog = false
//        }
//    }


//    val screens = listOf(
//        BottomBarScreen.Home,
//        BottomBarScreen.Explore,
//        BottomBarScreen.Profile,
////        BottomBarScreen.More
//    )

//    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
//    val currentDestination = navBackStackEntry?.destination
//
//    val bottomDestination = screens.any {
//        it.route == currentDestination?.route
//    }

    Box(modifier = Modifier.fillMaxSize()) {
        BottomNavGraph(navHostController = navHostController)
    }

//    Scaffold(
//        snackbarHost = {
//            SnackbarHost(hostState = snackbarHostState)
//        },
//        bottomBar = {
//            if(bottomDestination) {
//                BottomNavigationBar(
//                    navHostController = navHostController,
//                    screens = screens,
//                    currentDestination = currentDestination
//                )
//            }
//
//
//        },
//        floatingActionButton = {
//            if (bottomDestination) {
//                MrLingoFloating(navHostController)
//            }
//        },
//        floatingActionButtonPosition = FabPosition.End
//    ) {
//
//        Box(Modifier.padding(it)) {
//            BottomNavGraph(navHostController = navHostController)
//        }
//
//    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}




