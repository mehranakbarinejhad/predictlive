package com.liyanamarket.predictlive.view.thread.allusers

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.liyanamarket.predictlive.dataclass.Users
import com.liyanamarket.predictlive.presenter.login.Presenter
import com.liyanamarket.predictlive.presenter.login.Senddatatoview
import com.liyanamarket.predictlive.view.adapter.Rankinglist
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragmentranking.*
import java.lang.Exception

class Threadgetallusers(private var activity: AppCompatActivity):Thread(),Senddatatoview {
    override fun run() {
        activity.runOnUiThread {
            Presenter(this).getusers("selectuser","")
        }
    }

    override fun onsuccess(user: List<Users>) {
        try {
            Picasso.with(activity).load(user[0].image).into(activity.img_oneranking)
            activity.txt_nameoneranking.text=user[0].name
            activity.txt_scoreoneranking.text=user[0].Score.toString()
            Picasso.with(activity).load(user[1].image).into(activity.img_tworanking)
            activity.txt_nametworanking.text=user[1].name
            activity.txt_scoretworanking.text=user[1].Score.toString()
            Picasso.with(activity).load(user[2].image).into(activity.img_treeranking)
            activity.txt_namethreeranking.text=user[2].name
            activity.txt_scorethreeranking.text=user[2].Score.toString()
            val list=user as MutableList
            list.removeAt(0)
            list.removeAt(0)
            list.removeAt(0)
            activity.recycler_ranking.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
            activity.recycler_ranking.adapter=Rankinglist(activity,list)
            activity.relateiveparentranking.visibility=View.VISIBLE
        }
        catch (e:Exception){

        }


    }

    override fun onerror(t: Throwable) {
        Toast.makeText(activity,"Error",Toast.LENGTH_LONG).show()
    }
}