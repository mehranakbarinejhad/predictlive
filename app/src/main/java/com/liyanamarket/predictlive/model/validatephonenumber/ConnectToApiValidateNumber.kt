package com.liyanamarket.predictlive.model.validatephonenumber

import com.liyanamarket.predictlive.dataclass.ValidatePhoneNumber
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class ConnectToApiValidateNumber {
    fun result(): Apiservice {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://www.liyanamarket.ir/").build().create(Apiservice::class.java)
    }
}

interface Apiservice {
    @GET("Main.php")
    fun resultnumber(
        @Query("action") action: String,
        @Query("phonenumber") phonenumber: String
    ): Call<List<ValidatePhoneNumber>>
}