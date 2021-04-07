package com.liyanamarket.predictlive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_number.*
import kotlinx.android.synthetic.main.activity_validate_code.*

class ValidateCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validate_code)
        btn_next_validateactivity.setOnClickListener {
            val intent= Intent(this,LoginProfileActivity::class.java)
            startActivity(intent)
        }
    }
}