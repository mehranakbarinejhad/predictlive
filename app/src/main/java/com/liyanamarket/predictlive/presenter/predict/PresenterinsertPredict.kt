package com.liyanamarket.predictlive.presenter.predict


import com.liyanamarket.predictlive.dataclass.Resultpredict
import com.liyanamarket.predictlive.model.predict.ConnectToApiPRedict
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterinsertPredict(private val senddatatoview: Senddatatoview):Callback<List<Resultpredict>> {
    fun insertpredict(username:String,matchid:Int,hometeamgols:Int,guesteamgols:Int){
        ConnectToApiPRedict().insertpredict().insertpredict("insertorupdatepredict",username,matchid,hometeamgols,guesteamgols).enqueue(this)

    }

    override fun onResponse(
        call: Call<List<Resultpredict>>,
        response: Response<List<Resultpredict>>
    ) {
        val data=response.body()
        if(data!=null)
        {
            senddatatoview.onsuccess(data)
        }
    }

    override fun onFailure(call: Call<List<Resultpredict>>, t: Throwable) {
senddatatoview.onerror(t)    }
}
interface Senddatatoview{
    fun onsuccess(list:List<Resultpredict>)
    fun onerror(t:Throwable)
}