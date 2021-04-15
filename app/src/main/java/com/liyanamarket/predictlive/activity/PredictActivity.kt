package com.liyanamarket.predictlive.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.dataclass.Resultpredict
import com.liyanamarket.predictlive.presenter.predict.PresenterinsertPredict
import com.liyanamarket.predictlive.presenter.predict.Senddatatoview
import com.liyanamarket.predictlive.view.thread.match.Threadgetmatch

class PredictActivity : AppCompatActivity(),Senddatatoview {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_predict)
        PresenterinsertPredict(this).insertpredict("sanaz",1,3,5)
      Threadgetmatch(this,"13991220").start()
    }

    override fun onsuccess(list: List<Resultpredict>) {
        Toast.makeText(this,list[0].result,Toast.LENGTH_LONG).show()
    }

    override fun onerror(t: Throwable) {
        Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()

    }


}
