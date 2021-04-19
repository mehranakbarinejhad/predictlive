package com.liyanamarket.predictlive.fragment
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.liyanamarket.predictlive.R
class MessageFragment(private var titrmessage:String,private var textmessage: String,private var iconmessage:Int):DialogFragment() {
    lateinit var btnok:Button
    lateinit var txttitrmessage:TextView
    lateinit var txttextmessage:TextView
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
        txttitrmessage= view!!.findViewById(R.id.txt_titrmessage)
        txttextmessage= view!!.findViewById(R.id.txt_textmessage)
        imgmessage=view!!.findViewById(R.id.img_message)
        txttitrmessage.text=titrmessage
        txttextmessage.text=textmessage
        imgmessage.setImageResource(iconmessage)
        btnok.setOnClickListener {
           dismiss()
        }

    }
    override fun onStart() {
        super.onStart()
       val width=(resources.displayMetrics.widthPixels*0.85).toInt()

        dialog!!.window?.setLayout(width,ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog!!.setCancelable(false)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}