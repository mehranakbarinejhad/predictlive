package com.liyanamarket.predictlive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_success_register.*

class SuccessRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_register)
        img_success_successactivity.animation=AnimationUtils.loadAnimation(this,R.anim.zoomout)
  }
}