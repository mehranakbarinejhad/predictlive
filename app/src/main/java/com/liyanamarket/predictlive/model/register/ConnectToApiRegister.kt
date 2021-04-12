package com.liyanamarket.predictlive.model.register

import com.liyanamarket.predictlive.dataclass.Register
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class ConnectToApiRegister {
    fun register(): Apiservice {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://www.liyanamarket.ir/").build().create(Apiservice::class.java)
    }

}

interface Apiservice {
    @GET("Main.php")
    fun register(
        @Query("action") action: String,
        @Query("name") Name: String,
        @Query("username") Username: String,
        @Query("password") Password: String,
        @Query("phonenumber") Phonenumber: String

    ): Call<List<Register>>

}