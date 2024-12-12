package com.lingorise.app.screens.authscreens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.lingorise.app.core.corecomponents.buttons.CoreFilledButton
import com.lingorise.app.core.corecomponents.texts.CoreEditText
import com.lingorise.app.data.repository.fakedata.StoreUserData
import com.lingorise.app.domain.model.UserKey
import com.lingorise.app.navigation.navgraphs.Graph
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun BDAppsOTPScreen(
    navHostController: NavHostController,
    referenceId: String
) {

    val dataStore = StoreUserData(LocalContext.current)
    val scope = rememberCoroutineScope()
    var otp by remember {
        mutableStateOf("")
    }

    val scope1 = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Verification",
            fontSize = 24.sp,)
        Spacer(modifier = Modifier.height(32.dp))
        CoreEditText {
            otp = it
        }
        Spacer(modifier = Modifier.height(16.dp))
        CoreFilledButton(label = "Let's Start") {

            scope.launch {
                dataStore.saveUserType(UserKey().COURSE_ENROLLED)
            }
            navHostController.popBackStack()
            navHostController.popBackStack()
            navHostController.navigate(Graph.BOTTOM_NAV_ROUTE)
        }
    }
}