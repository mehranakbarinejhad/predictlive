package com.liyanamarket.predictlive.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.Toast

import com.liyanamarket.predictlive.R

import com.liyanamarket.predictlive.view.thread.register.ThreadRegister
import kotlinx.android.synthetic.main.activity_login_profile.*


class LoginProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_profile)
        linearparent_registeractivity.animation=AnimationUtils.loadAnimation(this,R.anim.zoomout)
        val phoneNumber = intent.getStringExtra("phonenumber")
        edt_phonenumber_loginprofileactivity.setText(phoneNumber)


        btn_register_loginprofileactivity.setOnClickListener {

            register(
                edt_name_loginprofileactivity,
                edt_username_loginprofileactivity,
                edt_password_loginprofileactivity,
                edt_confirm_loginprofileactivity,
                edt_phonenumber_loginprofileactivity
            )


        }


    }

    private fun register(
        name: EditText,
        username: EditText,
        password: EditText,
        confirm: EditText,
        phonenumber: EditText
    ) {
        if (name.text.isNotEmpty() && username.text.isNotEmpty() && password.text.isNotEmpty() && confirm.text.isNotEmpty()) {
            if (password.text.toString() == confirm.text.toString()) {
                ThreadRegister(
                    this,
                    name.text.toString().trim(),
                    username.text.toString().trim(),
                    password.text.toString().trim(),
                    phonenumber.text.toString().trim()
                ).start()
            } else {
                Toast.makeText(this, "password and confirm no equals!", Toast.LENGTH_LONG)
                    .show()

            }
        } else {
            Toast.makeText(this, "inputtext is  empty! please check inputs", Toast.LENGTH_LONG)
                .show()
        }
    }


}