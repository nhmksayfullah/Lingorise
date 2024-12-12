package com.lingorise.app.screens.profilescreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lingorise.app.core.corecomponents.texts.CoreDropDown
import com.lingorise.app.data.repository.fakedata.StoreUserData
import com.lingorise.app.screens.explorescreens.FeedScreen
import com.lingorise.app.screens.homescreen.NoticeDialog
import com.lingorise.app.screens.profilescreens.components.ActionButton
import com.lingorise.app.screens.profilescreens.components.HeaderBlock
import com.lingorise.app.screens.profilescreens.components.MyFriendsBlock

@Composable
fun ProfileScreen(
    navHostController: NavHostController
) {

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

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            HeaderBlock()
            ActionButton()
            MyFriendsBlock()


//            Text(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                text = "My Posts",
//                textAlign = TextAlign.Start
//            )
//            FeedScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}