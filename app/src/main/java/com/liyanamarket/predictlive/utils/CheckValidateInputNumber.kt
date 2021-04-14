package com.liyanamarket.predictlive.utils

import androidx.appcompat.app.AppCompatActivity
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.fragment.MessageFragment

class CheckValidateInputNumber(private val activity:AppCompatActivity) {

     fun validatenumber(phonenumber:String):Boolean {
        var bool=true
        when {
            phonenumber.isEmpty() -> {
                MessageFragment("Warning","Please Enter PhoneNumber", R.drawable.ic_warning).show(activity.supportFragmentManager,"Message")
                bool=false

            }
            phonenumber.startsWith('0') -> {
                MessageFragment("Warning","Please Enter PhoneNumber without 0 number", R.drawable.ic_warning).show(activity.supportFragmentManager,"Message")
                bool=false
            }
            phonenumber.length!=10 -> {
                MessageFragment("Warning","Phone Number Should Lenght 10", R.drawable.ic_warning).show(activity.supportFragmentManager,"Message")
                bool=false
            }

        }
        return bool

    }
}