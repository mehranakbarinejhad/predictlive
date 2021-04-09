package com.liyanamarket.predictlive.model.sms

import com.liyanamarket.predictlive.dataclass.SmsCode
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class ConnectToApiSendCode {
    fun sendcode(): ApiserviceSendCode {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://www.liyanamarket.ir/").build().create(ApiserviceSendCode::class.java)

    }
}

interface ApiserviceSendCode {
    @GET("Main.php")
    fun sendcode(@Query("action") action: String, @Query("phonenumber") phonenumber: String):Call<List<SmsCode>>
}