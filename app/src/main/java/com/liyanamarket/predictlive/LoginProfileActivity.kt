package com.liyanamarket.predictlive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login_profile.*

class LoginProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_profile)
        loginprofile_parent.animation= AnimationUtils.loadAnimation(this,R.anim.moveright)
          btn_register_loginprofileactivity.setOnClickListener {
              val intent= Intent(this,SuccessRegisterActivity::class.java)
              startActivity(intent)
          }
    }
}