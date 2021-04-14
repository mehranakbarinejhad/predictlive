package com.liyanamarket.predictlive.view.thread.validatephonenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.activity.ValidateCodeActivity
import com.liyanamarket.predictlive.dataclass.ValidatePhoneNumber
import com.liyanamarket.predictlive.fragment.MessageFragment
import com.liyanamarket.predictlive.presenter.validatephonenumber.PresenterValidateNumber
import com.liyanamarket.predictlive.presenter.validatephonenumber.Senddatatoview

class ThreadValidatePhoneNumber(private val activity: AppCompatActivity,private  val phonenumber:String):Thread(),Senddatatoview {
    override fun run() {
        activity.runOnUiThread {

            PresenterValidateNumber(this).getresult(phonenumber)

        }

    }

    override fun onsuccess(list: List<ValidatePhoneNumber>) {
        if(list[0].result)
        {
            MessageFragment("Error!","PhoneNumber Is Befor Registerd! Please Login!", R.drawable.ic_warning).show(activity.supportFragmentManager,"Message")

        }
        else
        {
            val intent=Intent(activity,ValidateCodeActivity::class.java)
            intent.putExtra("phonenumber",phonenumber)
            activity.startActivity(intent)


        }
    }

    override fun onerror(t: Throwable) {
        MessageFragment("Error!","Please Check Internet Status!",R.drawable.ic_error).show(activity.supportFragmentManager,"Message")


    }
}