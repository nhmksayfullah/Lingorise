package com.lingorise.app.screens.authscreens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.lingorise.app.core.corecomponents.buttons.CoreFilledButton
import com.lingorise.app.core.corecomponents.texts.CoreEditText
import com.lingorise.app.data.remote.dto.OtpViewModel
import com.lingorise.app.data.remote.dto.otpApiService
import com.lingorise.app.data.repository.fakedata.StoreUserData
import com.lingorise.app.domain.model.UserKey
import com.lingorise.app.navigation.navgraphs.Graph
import com.lingorise.app.navigation.screens.AuthScreen
import com.lingorise.app.navigation.screens.RootScreen
import com.lingorise.app.ui.theme.LingoriseLightRed
import com.lingorise.app.ui.theme.LingoriseRed
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun BDAppsPhoneScreen(
    navHostController: NavHostController
) {
    val viewModel: OtpViewModel = viewModel()
    val context = LocalContext.current
    val dataStore = StoreUserData(LocalContext.current)
//    var phoneNumber by remember {
//        mutableStateOf("88018")
//    }
    var label by remember {
        mutableStateOf("Get OTP")
    }
    val scope = rememberCoroutineScope()


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Authentication",
        fontSize = 24.sp,)
        Spacer(modifier = Modifier.height(32.dp))

//        TextField(value = phoneNumber, onValueChange = {
//            phoneNumber = it
//        })
        CoreEditText(
            defaultValue = viewModel.phone,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            ),
        ) {
            viewModel.phone = it
        }
        Spacer(modifier = Modifier.height(16.dp))
        CoreFilledButton(label = label) {
            viewModel.sendOtp(otpApiService)

            //navHostController.navigate("${AuthScreen.BDAppsOTPScreen.route}/1")

        }
        Spacer(modifier = Modifier.height(8.dp))

        CoreFilledButton(label = "Skip", buttonColor = LingoriseRed) {
            scope.launch {
                dataStore.saveUserType(UserKey().COURSE_ENROLLED)
            }
            navHostController.popBackStack()
            navHostController.navigate(Graph.BOTTOM_NAV_ROUTE)
        }
    }
    viewModel.otpResponse.observeForever {response ->
        if (response != null) {
            navHostController.navigate("${AuthScreen.BDAppsOTPScreen.route}/1")
        }
    }


}


//scope.launch {
//    RetrofitInstance.apiInterface.getOtp(phoneNumber).enqueue(object : Callback<BdAppsResponse1?> {
//        override fun onResponse(
//            call: Call<BdAppsResponse1?>,
//            response: Response<BdAppsResponse1?>
//        ) {
//            Log.d("my respose: ", response.toString())
//            if (response.body()?.statusCode == "S1000") {
//                navHostController.navigate("${AuthScreen.BDAppsOTPScreen}/${response.body()?.referenceNo ?: "failed"}")
//            }
//        }
//
//        override fun onFailure(call: Call<BdAppsResponse1?>, t: Throwable) {
//            label = "Try Again"
//        }
//    })
//}