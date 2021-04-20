package com.liyanamarket.predictlive.view.thread.login
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.liyanamarket.predictlive.App
import com.liyanamarket.predictlive.activity.HomeActivity
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.dataclass.Users
import com.liyanamarket.predictlive.fragment.MessageFragment
import com.liyanamarket.predictlive.fragment.ProgressbarFragment
import com.liyanamarket.predictlive.presenter.login.Presenter
import com.liyanamarket.predictlive.presenter.login.Senddatatoview
import com.liyanamarket.predictlive.utils.DisMissProgressbar
import com.liyanamarket.predictlive.utils.Savelogininfo
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.core.KoinComponent
import org.koin.core.inject


class ThreadLogin(val activity:AppCompatActivity, private val username:String, private val password:String):Thread(),Senddatatoview,KoinComponent {
 private val savelogininfo:Savelogininfo by inject()
    override fun run() {
       activity.runOnUiThread {

           if(username.isEmpty())
           {
               MessageFragment("هشدار!","لطفا نام کاربری را وارد نمایید.",R.drawable.ic_warning).show(activity.supportFragmentManager,"Message")
               return@runOnUiThread

           }
         ProgressbarFragment().show(activity.supportFragmentManager,"progressbar")

           Presenter(this).getusers("selectuser", username)

           }
    }

    override fun onsuccess(user: List<Users>) {
        DisMissProgressbar(activity).dismiss()



        if(user.count()!=0) {
            if(password.isEmpty())
            {
                MessageFragment("هشدار!","لطفا رمز عبور را وارد نمایید.",R.drawable.ic_warning).show(activity.supportFragmentManager,"Message")
                return
            }


            if(password==user[0].password)
            {
                 val pref=activity.getSharedPreferences("saveusername", Context.MODE_PRIVATE)
                pref.edit().putString("username",username).apply()

                val intent=Intent(activity, HomeActivity::class.java)
                intent.putExtra("usernameloginuser",username)
                intent.putExtra("nameuser",user[0].name)
                intent.putExtra("passwordloginuser",password)
                intent.putExtra("imageloginuser",user[0].image)
                intent.putExtra("phonenumberloginuser",user[0].phonenumber)
                intent.putExtra("scoreloginuser",user[0].Score)

                activity.startActivity(intent)
                activity.finishAffinity()
                if(activity.swch_remmemberme.isChecked) {
                    savelogininfo.save(username, password)
                }
                else
                {
                   savelogininfo.save("","")
                }


            }
            else
            {
               MessageFragment("خطا!","رمز عبور اشتباه می باشد.",R.drawable.ic_error).show(activity.supportFragmentManager,"Message")
                return


            }

        }
        else
        {
            MessageFragment("خطا!","نام کاربری اشتباه می باشد.\nاگر حساب کاربری ندارید لطفا ثبت نام نمایید.",R.drawable.ic_error).show(activity.supportFragmentManager,"Message")
            return
        }


    }

    override fun onerror(t: Throwable) {
       DisMissProgressbar(activity).dismiss()

        MessageFragment("خطا!","لطفا اتصال به اینترنت را بررسی نمایید",R.drawable.ic_error).show(activity.supportFragmentManager,"Message")

    }


}
