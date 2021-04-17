package com.liyanamarket.predictlive.view.thread.predict

import androidx.appcompat.app.AppCompatActivity
import com.liyanamarket.predictlive.dataclass.Resultpredict
import com.liyanamarket.predictlive.presenter.predict.PresenterinsertPredict
import com.liyanamarket.predictlive.presenter.predict.Senddatatoview

class ThreadInsertPredictuser(val activity: AppCompatActivity,var username:String,var matchid:Int,var userhometeamgols:Int,var userguestteamgols:Int):Thread(),Senddatatoview {
    override fun run() {
        activity.runOnUiThread {
            PresenterinsertPredict(this).insertpredict(username,matchid,userhometeamgols,userguestteamgols)
        }
    }

    override fun onsuccess(list: List<Resultpredict>) {

    }

    override fun onerror(t: Throwable) {

    }

}