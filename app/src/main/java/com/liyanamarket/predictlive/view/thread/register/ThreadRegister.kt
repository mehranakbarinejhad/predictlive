package com.liyanamarket.predictlive.view.thread.register
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.activity.SuccessRegisterActivity
import com.liyanamarket.predictlive.dataclass.Register
import com.liyanamarket.predictlive.fragment.MessageFragment
import com.liyanamarket.predictlive.presenter.register.PresenterRegister
import com.liyanamarket.predictlive.presenter.register.Senddatatoview
class ThreadRegister(
    private val activity: AppCompatActivity,
    private val completname:String,
    private val username: String,
    private val password: String,
    private val phonenumber:String
) : Thread(), Senddatatoview {
    override fun run() {
        activity.runOnUiThread {
            PresenterRegister(this).register(completname,username,password,phonenumber)
        }

    }

    override fun onsuccess(result: List<Register>) {
        when (result[0].result) {
            "success" -> {
                val intent=Intent(activity,SuccessRegisterActivity::class.java)
                activity.startActivity(intent)
                activity.finishAffinity()
            }
            "username" -> {
                MessageFragment("Error!","Username Is Validate! Please Another Username", R.drawable.ic_error).show(activity.supportFragmentManager,"Message")

            }

        }
    }


    override fun onerror(t: Throwable) {
        MessageFragment("Error!","Please Check Internet Status!",R.drawable.ic_error).show(activity.supportFragmentManager,"Message")
    }
}

