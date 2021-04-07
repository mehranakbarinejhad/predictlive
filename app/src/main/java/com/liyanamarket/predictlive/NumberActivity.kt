package com.liyanamarket.predictlive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_number.*

class NumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
       btn_next_numberactivity.setOnClickListener {
           val intent=Intent(this,ValidateCodeActivity::class.java)
           startActivity(intent)
       }
    }
}