package com.liyanamarket.predictlive.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.view.thread.predict.ThreadPredictActivity


class PredictActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_predict)
        val pref=getSharedPreferences("saveusername", Context.MODE_PRIVATE)
        val username=pref.getString("username","").toString()
        ThreadPredictActivity(this,username,"13991220").start()

    }






}
