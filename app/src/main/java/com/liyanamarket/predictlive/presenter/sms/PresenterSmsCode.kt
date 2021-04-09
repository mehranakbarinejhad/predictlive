package com.liyanamarket.predictlive.presenter.sms

import com.liyanamarket.predictlive.dataclass.SmsCode
import com.liyanamarket.predictlive.model.sms.ConnectToApiSendCode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterSmsCode(private var senddatatoview: Senddatatoview) : Callback<List<SmsCode>> {
    fun getcode(phonenumber:String) {
        ConnectToApiSendCode().sendcode().sendcode("sendcodesms", phonenumber).enqueue(this)
    }

    override fun onResponse(call: Call<List<SmsCode>>, response: Response<List<SmsCode>>) {
        val data = response.body()
        if (data != null) {
            senddatatoview.onssuccess(data)
        }
    }

    override fun onFailure(call: Call<List<SmsCode>>, t: Throwable) {
        senddatatoview.onerror(t)
    }
}

interface Senddatatoview {
    fun onssuccess(list: List<SmsCode>)
    fun onerror(Error: Throwable)

}