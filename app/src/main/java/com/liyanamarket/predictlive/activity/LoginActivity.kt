package com.liyanamarket.predictlive.activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.view.thread.login.ThreadLogin
import kotlinx.android.synthetic.main.activity_login.*
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_login.setOnClickListener {
            ThreadLogin(this,edt_username.text.toString(),edt_password.text.toString(),btn_login).start()


        }
        txt_createaccountclick.setOnClickListener {
            val intent=Intent(this,NumberActivity::class.java)
            startActivity(intent)
        }
    }
}
