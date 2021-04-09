package com.liyanamarket.predictlive.view.thread.sms

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.liyanamarket.predictlive.activity.ValidateCodeActivity
import com.liyanamarket.predictlive.dataclass.SmsCode
import com.liyanamarket.predictlive.presenter.sms.PresenterSmsCode
import com.liyanamarket.predictlive.presenter.sms.Senddatatoview

class ThreadSendCode(
    private val activity: AppCompatActivity,
    private val phonenumber: String,
    private val sendcodetovalidate: Sendcodetovalidate
) : Thread(), Senddatatoview {

    override fun run() {
        activity.runOnUiThread {
            PresenterSmsCode(this).getcode(phonenumber)
        }

    }

    override fun onssuccess(list: List<SmsCode>) {
        val smscode = list[0].code
        val phonenumber = list[0].phonenumber
        sendcodetovalidate.senddata(smscode,phonenumber)

    }

    override fun onerror(Error: Throwable) {
        Toast.makeText(activity, "Error", Toast.LENGTH_LONG).show()
    }
}
interface Sendcodetovalidate{
    fun senddata(code:String,phonenumber:String)

}

