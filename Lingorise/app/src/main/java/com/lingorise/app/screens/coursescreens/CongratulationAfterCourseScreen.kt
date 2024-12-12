package com.lingorise.app.screens.coursescreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.lingorise.app.core.constants.congressFace
import com.lingorise.app.core.constants.congressFlower
import com.lingorise.app.core.corecomponents.buttons.CoreFilledButton
import com.lingorise.app.data.repository.fakedata.StoreUserData
import com.lingorise.app.screens.homescreen.NoticeDialog
import com.lingorise.app.ui.theme.LingoriseRed
import com.lingorise.app.ui.theme.LingoriseSkyBlue
import com.lingorise.app.ui.theme.LingoriseYellow

@Composable
fun CourseCompletedScreen(
    certificate: Int,
    navHostController: NavHostController
) {

    val dataStore = StoreUserData(LocalContext.current)
//    val dialogState = dataStore.readDialogState.collectAsState(initial = false)
    var openDialog by remember {
        mutableStateOf(false)
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = congressFace,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Congratulation $congressFlower",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = LingoriseSkyBlue,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "You have just finished the course!",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))


        Card(
            modifier = Modifier
                .wrapContentSize(),
            elevation = 4.dp
        ) {
            Image(
                painter = painterResource(id = certificate),
                contentDescription = "certificate of completion",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            Modifier.fillMaxWidth()
        ) {
            CoreFilledButton(
                label = "Download the certificate",
                buttonColor = LingoriseRed,
                modifier = Modifier
                    .weight(.7f)
            ) {
                openDialog = true
            }

            Spacer(modifier = Modifier.width(4.dp))

            CoreFilledButton(label = "Share",
                buttonColor = LingoriseRed,
                modifier = Modifier
                    .weight(.3f)
            ) {
                openDialog = true
            }
        }


        Spacer(modifier = Modifier.height(20.dp))

        CoreFilledButton(label = "Check your progress", buttonColor = LingoriseSkyBlue) {
            openDialog = true

        }
        CoreFilledButton(label = "Recommend a new chunk", buttonColor = LingoriseYellow) {
            openDialog = true

        }
    }

}