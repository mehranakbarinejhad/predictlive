package com.liyanamarket.predictlive.view.thread.login
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.activity.MainActivity
import com.liyanamarket.predictlive.dataclass.Users
import com.liyanamarket.predictlive.fragment.MessageFragment
import com.liyanamarket.predictlive.presenter.login.Presenter
import com.liyanamarket.predictlive.presenter.login.Senddatatoview

class ThreadLogin(val activity:AppCompatActivity, private val username:String, private val password:String):Thread(),Senddatatoview {
    override fun run() {
       activity.runOnUiThread {
           if(username.isEmpty())
           {
               MessageFragment("Please Enter Username",R.drawable.ic_warning).show(activity.supportFragmentManager,"Message")
               return@runOnUiThread

           }

               Presenter(this).getusers("selectuser", username)

           }
    }

    override fun onsuccess(user: List<Users>) {
        if(user.count()!=0) {
            if(password.isEmpty())
            {
                MessageFragment("Please Enter Password",R.drawable.ic_warning).show(activity.supportFragmentManager,"Message")
                return

            }


            if(password==user[0].password)
            {
                val intent=Intent(activity,MainActivity::class.java)
                activity.startActivity(intent)
                activity.finishAffinity()
            }
            else
            {
               MessageFragment("password wrong",R.drawable.ic_error).show(activity.supportFragmentManager,"Message")
            }

        }
        else
        {
            MessageFragment("UserName Note Found",R.drawable.ic_error).show(activity.supportFragmentManager,"Message")

        }
    }

    override fun onerror(t: Throwable) {
        MessageFragment("please check internet status",R.drawable.ic_error).show(activity.supportFragmentManager,"Message")

    }

}