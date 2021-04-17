package com.liyanamarket.predictlive.presenter.predict

import com.liyanamarket.predictlive.dataclass.Match
import com.liyanamarket.predictlive.dataclass.Predict
import com.liyanamarket.predictlive.model.predict.ConnectToAPiSelectPredict
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterSelectPredict(var sendpredictlisttoview: Sendpredictlisttoview):Callback<List<Predict>>{
    fun selectpredict(username:String){
        ConnectToAPiSelectPredict().selectpredict().selectpredicuser("selectpredictbyuser",username).enqueue(this)
    }

    override fun onResponse(call: Call<List<Predict>>, response: Response<List<Predict>>) {
        val data=response.body()
        if(data!=null)
        {
            sendpredictlisttoview.onsuccesslistpredict(data)
        }
    }

    override fun onFailure(call: Call<List<Predict>>, t: Throwable) {
        sendpredictlisttoview.onerrorlistpredict(t)
    }
}
interface Sendpredictlisttoview{
    fun onsuccesslistpredict(list: List<Predict>)
    fun onerrorlistpredict(t:Throwable)
}