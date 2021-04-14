package com.liyanamarket.predictlive.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

class DisMissProgressbar(private val activity: AppCompatActivity) {
    fun dismiss(){
       ( activity.supportFragmentManager.findFragmentByTag("progressbar")as DialogFragment).dismiss()
    }

}