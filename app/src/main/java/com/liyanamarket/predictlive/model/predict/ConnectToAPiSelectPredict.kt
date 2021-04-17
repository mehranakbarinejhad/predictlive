package com.liyanamarket.predictlive.model.predict

import com.liyanamarket.predictlive.dataclass.Predict
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class ConnectToAPiSelectPredict {
    fun selectpredict():Apiservices{
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://www.liyanamarket.ir/")
            .build().create(Apiservices::class.java)

    }
}
interface Apiservices{
   @GET("Main.php")
   fun selectpredicuser(
       @Query("action")action:String,
       @Query("username")username:String,


   ):Call<List<Predict>>

}