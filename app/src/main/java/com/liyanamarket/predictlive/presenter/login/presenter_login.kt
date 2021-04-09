package com.liyanamarket.predictlive.presenter.login

import com.liyanamarket.predictlive.dataclass.Users
import com.liyanamarket.predictlive.model.login.ConnectToApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(private val senddatatoview: Senddatatoview):Callback<List<Users>> {
    fun getusers(action:String,username:String){
        val connect=ConnectToApi()
        connect.getdata().getusers(action,username).enqueue(this)
    }
    override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
        val data=response.body()
        if(data!=null)
        {
            senddatatoview.onsuccess(data)
        }
    }

    override fun onFailure(call: Call<List<Users>>, t: Throwable) {
        senddatatoview.onerror(t)
    }
}
interface Senddatatoview{
    fun onsuccess(user:List<Users>)
    fun onerror(t:Throwable)
}
