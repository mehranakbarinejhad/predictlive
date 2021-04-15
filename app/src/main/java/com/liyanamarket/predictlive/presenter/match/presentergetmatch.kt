package com.liyanamarket.predictlive.presenter.match

import androidx.appcompat.app.AppCompatActivity
import com.liyanamarket.predictlive.dataclass.Match
import com.liyanamarket.predictlive.model.match.ConnectToApiMatch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class presentergetmatch(private val activity: AppCompatActivity,private val senddatatoview: Senddatatoview):Callback<List<Match>> {

    fun getmatch(matchdate:String)
    {
        ConnectToApiMatch().getmatch().getmatch("selectmatch",matchdate).enqueue(this)
    }

    override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {
        val data=response.body()
        if(data!=null)
        {
           senddatatoview.onsuccess(data)
        }
    }

    override fun onFailure(call: Call<List<Match>>, t: Throwable) {
      senddatatoview.onerror(t)
    }
}
interface Senddatatoview{
    fun onsuccess(list: List<Match>)
    fun  onerror(t: Throwable)
}