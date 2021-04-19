package com.liyanamarket.predictlive.presenter.changeprofile

import android.widget.Toast
import com.liyanamarket.predictlive.dataclass.changeprofile
import com.liyanamarket.predictlive.model.changeprofile.ApiConnectToAPIChangeProfile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterChangeProfile(var sendchangeprofiledatatoview: Sendchangeprofiledatatoview):Callback<List<changeprofile>> {
    fun changeprofile(strimage:String,username:String){
        ApiConnectToAPIChangeProfile().change().change("changeprofile",strimage,username).enqueue(this)
    }

    override fun onResponse(
        call: Call<List<changeprofile>>,
        response: Response<List<changeprofile>>
    ) {
        val data=response.body()
        if(data!=null)
        {
            sendchangeprofiledatatoview.onsuccess(data)
        }
    }

    override fun onFailure(call: Call<List<changeprofile>>, t: Throwable) {
       sendchangeprofiledatatoview.onerror(t)
    }
}

interface Sendchangeprofiledatatoview{
    fun onsuccess(list: List<changeprofile>)
    fun onerror(t:Throwable)
}