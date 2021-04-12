package com.liyanamarket.predictlive.presenter.register
import com.liyanamarket.predictlive.dataclass.Register
import com.liyanamarket.predictlive.model.register.ConnectToApiRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterRegister(private val senddatatoview: Senddatatoview):Callback<List<Register>> {
    fun register(name:String,username:String,password:String,phonenumber:String){
        ConnectToApiRegister().register().register("insertuser",name,username,password,phonenumber).enqueue(this)
    }



    override fun onFailure(call: Call<List<Register>>, t: Throwable) {
        senddatatoview.onerror(t)    }

    override fun onResponse(call: Call<List<Register>>, response: Response<List<Register>>) {
        val data=response.body()
        if(data!=null)
        {
            senddatatoview.onsuccess(data)
        }
    }


}

interface Senddatatoview{
    fun onsuccess(result:List<Register>)
    fun onerror(t:Throwable)
}
