package com.lingorise.app.data.remote.dto

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query


data class OtpResponse(
    val referenceNo: String,
    val statusCode: Int,
    val statusDetail: String,
    val version: String
)

interface OtpApiService {
    @POST("sent/otp")
    suspend fun sendOtp(@Query("phone") phone: String): OtpResponse
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.lingorise.com/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val otpApiService = retrofit.create(OtpApiService::class.java)









class OtpViewModel : ViewModel() {
    var phone by mutableStateOf("88018")
    var otpResponse = MutableLiveData<OtpResponse?>()


    fun sendOtp(apiService: OtpApiService) {
        viewModelScope.launch {
            try {
                val response = apiService.sendOtp(phone)
                otpResponse.value = response
                Log.d("my response: ", response.toString())
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }
}