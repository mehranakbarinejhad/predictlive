package com.liyanamarket.predictlive.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.liyanamarket.predictlive.R

class SuccessRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_register)

  }

    override fun onBackPressed() {
        val intent=Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finishAffinity()

    }
}