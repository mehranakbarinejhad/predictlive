package com.liyanamarket.predictlive.activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.utils.Savelogininfo
import com.liyanamarket.predictlive.view.thread.login.ThreadLogin
import kotlinx.android.synthetic.main.activity_login.*
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val logininfo=Savelogininfo(this).load()
        val username=logininfo.first
        val password=logininfo.second
        if(username!=""&&password!="")
        {
         edt_username.setText(username)
         edt_password.setText(password)
        }
        else{
            swch_remmemberme.isChecked=false
        }

        btn_login.setOnClickListener {
            ThreadLogin(this,edt_username.text.toString(),edt_password.text.toString()).start()


        }
        txt_createaccountclick.setOnClickListener {
            val intent=Intent(this,NumberActivity::class.java)
            startActivity(intent)
        }
        txt_revovery.setOnClickListener {
            val intent=Intent(this,RecoveryActivity::class.java)
            startActivity(intent)
        }
    }
}
