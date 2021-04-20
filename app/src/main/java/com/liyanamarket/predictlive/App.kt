package com.liyanamarket.predictlive

import android.app.Application
import com.liyanamarket.predictlive.utils.koin.appmadule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App:Application() {
    override fun onCreate() {
        super.onCreate()
     startKoin {
         androidContext(this@App)
         modules(listOf(appmadule))
     }

    }

}