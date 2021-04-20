package com.liyanamarket.predictlive.utils

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.liyanamarket.predictlive.dataclass.Users

class Savelogininfo(private val context: Context) {
    private val pref=context.getSharedPreferences("logininfo",Context.MODE_PRIVATE)
    fun save(username:String,password:String)
    {

        pref.edit().putString("username",username).putString("password",password).apply()

    }
    fun load():Pair<String,String>{
        val username=pref.getString("username","").toString()
        val password=pref.getString("password","").toString()
        return Pair(username,password)

    }
}