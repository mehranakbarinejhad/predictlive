package com.liyanamarket.predictlive.view.thread.login
import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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

class ThreadLogin(val activity:AppCompatActivity, private val username:String, private val password:String):Thread(),Senddatatoview {
    override fun run() {
       activity.runOnUiThread {

           if(username.isEmpty())
           {
               MessageFragment("Warning!","Username is Empty!please Enter UserName.",R.drawable.ic_warning).show(activity.supportFragmentManager,"Message")
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
                MessageFragment("Warning!","Password is Empty!please Enter Password",R.drawable.ic_warning).show(activity.supportFragmentManager,"Message")
                return
            }


            if(password==user[0].password)
            {
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
                    Savelogininfo(activity).save(username, password)
                }
                else
                {
                    Savelogininfo(activity).save("","")
                }


            }
            else
            {
               MessageFragment("Error!","password is Wrong!Please Check Password",R.drawable.ic_error).show(activity.supportFragmentManager,"Message")
                return


            }

        }
        else
        {
            MessageFragment("Error!","UserName Note Found!If Dont Account,Please Register Then Login. ",R.drawable.ic_error).show(activity.supportFragmentManager,"Message")
            return
        }


    }

    override fun onerror(t: Throwable) {
       DisMissProgressbar(activity).dismiss()

        MessageFragment("Error!","Please Check Internet Status!",R.drawable.ic_error).show(activity.supportFragmentManager,"Message")

    }


}