package com.liyanamarket.predictlive.model.changeprofile

import com.liyanamarket.predictlive.dataclass.changeprofile
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

class ApiConnectToAPIChangeProfile {
    fun change():apiservice{
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://www.liyanamarket.ir/")
            .build().create(apiservice::class.java)
    }
}
interface apiservice{
    @FormUrlEncoded
    @POST("Main.php")
    fun change(
        @Field("action")action:String,
        @Field("strimage")strimage:String,
        @Field("username")username:String,
    ):Call<List<changeprofile>>

}