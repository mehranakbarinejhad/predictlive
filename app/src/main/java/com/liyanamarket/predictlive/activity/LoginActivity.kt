package com.liyanamarket.predictlive.activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.utils.Savelogininfo
import com.liyanamarket.predictlive.view.thread.login.ThreadLogin
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.context.GlobalContext.get


class LoginActivity : AppCompatActivity(){
    val savelogininfo2:Savelogininfo by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val logininfo=savelogininfo2.load()
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
