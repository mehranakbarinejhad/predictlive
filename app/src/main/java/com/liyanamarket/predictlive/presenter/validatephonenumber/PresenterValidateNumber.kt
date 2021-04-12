package com.liyanamarket.predictlive.presenter.validatephonenumber

import com.liyanamarket.predictlive.dataclass.ValidatePhoneNumber
import com.liyanamarket.predictlive.model.validatephonenumber.ConnectToApiValidateNumber
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterValidateNumber(private val senddatatoview: Senddatatoview):Callback<List<ValidatePhoneNumber>> {

    fun getresult(phonenumber:String){
       ConnectToApiValidateNumber().result().resultnumber("validatephonenumber",phonenumber).enqueue(this)

    }

    override fun onResponse(
        call: Call<List<ValidatePhoneNumber>>,
        response: Response<List<ValidatePhoneNumber>>
    ) {
       val data=response.body()
            if(data!=null)
            {
             senddatatoview.onsuccess(data)
            }
    }

    override fun onFailure(call: Call<List<ValidatePhoneNumber>>, t: Throwable) {
            senddatatoview.onerror(t)
            }
}
interface Senddatatoview{
    fun onsuccess(list: List<ValidatePhoneNumber>)
    fun onerror(t:Throwable)
}