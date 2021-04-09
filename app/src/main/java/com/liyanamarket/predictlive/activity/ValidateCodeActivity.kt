package com.liyanamarket.predictlive.activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.liyanamarket.predictlive.R

import com.liyanamarket.predictlive.view.thread.sms.Sendcodetovalidate
import com.liyanamarket.predictlive.view.thread.sms.ThreadSendCode
import kotlinx.android.synthetic.main.activity_validate_code.*

class ValidateCodeActivity : AppCompatActivity(),Sendcodetovalidate {
    lateinit var code:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validate_code)
        val phonenumber=intent.getStringExtra("phonenumber").toString()
        ThreadSendCode(this,phonenumber,this).start()
        btn_next_validateactivity.setOnClickListener {
            val enteringtext=textCode(edt_numberone_validateactivity,edt_numbertwo_validateactivity,edt_numberthree_validateactivity,edt_numberfor_validateactivity,edt_numberfive_validateactivity)
            if(enteringtext==code) {
                val intent=Intent(this,LoginProfileActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(this,"wrong password",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun senddata(code: String, phonenumber: String) {
                this.code=code
    }

     private fun textCode(num1: EditText,num2: EditText,num3: EditText,num4: EditText,num5: EditText):String{
        return num1.text.toString()+num2.text.toString()+num3.text.toString()+num4.text.toString()+num5.text.toString()
    }
}