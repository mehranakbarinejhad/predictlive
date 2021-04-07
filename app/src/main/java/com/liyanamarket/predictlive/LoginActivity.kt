package com.liyanamarket.predictlive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        txt_createaccountclick.setOnClickListener {
            val intent=Intent(this,NumberActivity::class.java)
            startActivity(intent)
        }

    }
}