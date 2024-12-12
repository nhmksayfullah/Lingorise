package com.lingorise.app.screens.mrlingoscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.lingorise.app.data.repository.fakedata.StoreUserData
import com.lingorise.app.navigation.navgraphs.Graph
import com.lingorise.app.screens.homescreen.NoticeDialog
import com.lingorise.app.screens.mrlingoscreen.components.MrLingoBottomBar
import com.lingorise.app.screens.mrlingoscreen.components.MrLingoHeader

@Composable
fun MrLingoScreen(
    navHostController: NavHostController
) {

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    val dataStore = StoreUserData(LocalContext.current)
//    val dialogState = dataStore.readDialogState.collectAsState(initial = false)
    var openDialog by remember {
        mutableStateOf(true)
    }
    if (openDialog) {
        NoticeDialog(
            dataStore = dataStore,
            state = openDialog
        ) {
            openDialog = false
            navHostController.popBackStack()
        }
    }

    Scaffold(
        topBar = {
            MrLingoHeader()
        },
        bottomBar = {
            MrLingoBottomBar()
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            Column {

            }
        }
    }




}