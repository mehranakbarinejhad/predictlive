package com.liyanamarket.predictlive.model.login

import com.liyanamarket.predictlive.dataclass.Users
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class ConnectToApi {
    fun getdata(): Apiservice {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://www.liyanamarket.ir/").build().create(Apiservice::class.java)
    }
}

interface Apiservice {
    @GET("Main.php")
    fun getusers(
        @Query("action")action:String,
        @Query("username")username:String

    ): Call<List<Users>>
}