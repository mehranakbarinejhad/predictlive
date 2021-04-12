package com.liyanamarket.predictlive.activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.utils.CheckValidateInputNumber
import com.liyanamarket.predictlive.view.thread.validatephonenumber.ThreadValidatePhoneNumber

import kotlinx.android.synthetic.main.activity_number.*

class NumberActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
btn_next_numberactivity.setOnClickListener {


    if(CheckValidateInputNumber(this).validatenumber(edt_phonenumber_numberactivity.text.toString())) {

      ThreadValidatePhoneNumber(this,edt_phonenumber_numberactivity.text.toString()).start()
    }



}

        txt_loginclick_numberactivity.setOnClickListener {
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }

    }



}