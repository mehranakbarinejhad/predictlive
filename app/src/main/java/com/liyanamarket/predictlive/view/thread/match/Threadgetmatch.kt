package com.liyanamarket.predictlive.view.thread.match

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.liyanamarket.predictlive.dataclass.Match
import com.liyanamarket.predictlive.presenter.match.Senddatatoview
import com.liyanamarket.predictlive.presenter.match.presentergetmatch
import com.liyanamarket.predictlive.view.adapter.Matchlist
import kotlinx.android.synthetic.main.activity_predict.*

class Threadgetmatch(private val activity: AppCompatActivity, private val matchdate:String):Thread(),Senddatatoview {
    override fun run() {
        activity.runOnUiThread {
            presentergetmatch(activity,this).getmatch(matchdate)
        }

    }

    override fun onsuccess(list: List<Match>) {
        activity.recycler_predictlist.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        activity.recycler_predictlist.adapter = Matchlist(activity, list)
    }
    override fun onerror(t: Throwable) {
        Toast.makeText(activity,"Error",Toast.LENGTH_LONG).show()    }
}