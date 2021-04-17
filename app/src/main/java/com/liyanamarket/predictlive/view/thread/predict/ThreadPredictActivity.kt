package com.liyanamarket.predictlive.view.thread.predict

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.liyanamarket.predictlive.dataclass.Match
import com.liyanamarket.predictlive.dataclass.Predict
import com.liyanamarket.predictlive.presenter.match.PredictAdapter
import com.liyanamarket.predictlive.presenter.match.Senddatatoview
import com.liyanamarket.predictlive.presenter.match.presentergetmatch
import com.liyanamarket.predictlive.presenter.predict.PresenterSelectPredict
import com.liyanamarket.predictlive.presenter.predict.Sendpredictlisttoview
import kotlinx.android.synthetic.main.activity_predict.*

class ThreadPredictActivity(var activity: AppCompatActivity,var username:String,var matchdate:String):Thread(),Senddatatoview,Sendpredictlisttoview {
   var predictlist= listOf<Predict>( )
    override fun run() {
        activity.runOnUiThread {
            PresenterSelectPredict(this).selectpredict(username)



        }
    }

    override fun onsuccesslistmatch(list: List<Match>) {

        activity.recycler_predictlist.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        activity.recycler_predictlist.adapter = PredictAdapter(activity, list, predictlist)









    }

    override fun onerrorlistmatch(t: Throwable) {
        Toast.makeText(activity,"ErrorMatch",Toast.LENGTH_LONG).show()

    }

    override fun onsuccesslistpredict(list: List<Predict>) {
            predictlist = list
            presentergetmatch(activity, this).getmatch(matchdate)



    }

    override fun onerrorlistpredict(t: Throwable) {
        Toast.makeText(activity,"ErrorPredict",Toast.LENGTH_LONG).show()

    }


}