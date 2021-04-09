package com.liyanamarket.predictlive.fragment

import android.media.Image
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment

import com.liyanamarket.predictlive.R

class MessageFragment(private var message: String,private var iconmessage:Int):DialogFragment() {
    lateinit var btnok:Button
    lateinit var txtmessage:TextView
    lateinit var imgmessage:ImageView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.message,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnok= view!!.findViewById(R.id.btn_ok)
        txtmessage= view!!.findViewById(R.id.txt_message)
        imgmessage=view!!.findViewById(R.id.img_message)
        txtmessage.text=message
        imgmessage.setImageResource(iconmessage)
        btnok.setOnClickListener {
           dismiss()
        }

    }
    override fun onStart() {
        super.onStart()
       val width=(resources.displayMetrics.widthPixels*0.85).toInt()
        val height=(resources.displayMetrics.heightPixels*0.50).toInt()
        dialog!!.window?.setLayout(width,height)
        dialog!!.setCancelable(false)
    }
}