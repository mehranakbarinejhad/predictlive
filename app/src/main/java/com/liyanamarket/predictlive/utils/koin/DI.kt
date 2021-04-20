package com.liyanamarket.predictlive.utils.koin

import androidx.appcompat.app.AppCompatActivity
import com.liyanamarket.predictlive.model.login.ConnectToApi
import com.liyanamarket.predictlive.presenter.login.Presenter
import com.liyanamarket.predictlive.utils.DisMissProgressbar
import com.liyanamarket.predictlive.utils.Savelogininfo
import com.liyanamarket.predictlive.view.thread.login.ThreadLogin
import com.squareup.picasso.Picasso
import org.koin.dsl.module


val appmadule= module{
    single {

        //Presenter(get())
        Savelogininfo(get())

      //  DisMissProgressbar(get())
    }
    single {
        Picasso.with(get())
    }
}