package com.liyanamarket.predictlive.fragment


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.liyanamarket.predictlive.R

class ProgressbarFragment:DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.progressbar,container,false)

    }

    override fun onStart() {
        super.onStart()
        val width=(resources.displayMetrics.widthPixels*0.85).toInt()
        dialog!!.window?.setLayout(width,ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog!!.setCancelable(false)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}