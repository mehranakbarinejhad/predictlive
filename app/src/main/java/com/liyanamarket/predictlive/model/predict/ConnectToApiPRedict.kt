package com.liyanamarket.predictlive.model.predict

import com.liyanamarket.predictlive.dataclass.Resultpredict
import com.liyanamarket.predictlive.model.match.apiservice
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class ConnectToApiPRedict {
    fun insertpredict():Apiservice{
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://www.liyanamarket.ir/")
            .build().create(Apiservice::class.java)
    }

}
interface Apiservice{
    @GET("Main.php")
    fun insertpredict(
        @Query("action")action:String,
        @Query("username")username:String,
        @Query("matchid")matchid:Int,
        @Query("hometeamgols")hometeamgols:Int,
        @Query("guestteamgols")guestteamgols:Int

    ):Call<List<Resultpredict>>
}