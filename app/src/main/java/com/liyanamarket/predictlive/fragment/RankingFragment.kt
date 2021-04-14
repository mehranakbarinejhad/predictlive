package com.liyanamarket.predictlive.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.view.thread.allusers.Threadgetallusers

class RankingFragment(private val activity: AppCompatActivity):Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmentranking,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Threadgetallusers(activity).start()
    }
}