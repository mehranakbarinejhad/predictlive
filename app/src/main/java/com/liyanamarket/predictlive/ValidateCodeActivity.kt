package com.liyanamarket.predictlive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_validate_code.*

class ValidateCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validate_code)
        validateactivity_parent.animation= AnimationUtils.loadAnimation(this,R.anim.moveright)
        btn_next_validateactivity.setOnClickListener {
            val intent= Intent(this,LoginProfileActivity::class.java)
            startActivity(intent)
        }
    }
}