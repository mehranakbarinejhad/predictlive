package com.liyanamarket.predictlive.model.match

import com.liyanamarket.predictlive.dataclass.Match
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class ConnectToApiMatch {
    fun getmatch():apiservice{
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://www.liyanamarket.ir/")
            .build().create(apiservice::class.java)
    }
}
interface apiservice{
    @GET("Main.php")
    fun getmatch(
        @Query("action")action:String,
        @Query("matchdate")matchdate:String

    ):Call<List<Match>>

}