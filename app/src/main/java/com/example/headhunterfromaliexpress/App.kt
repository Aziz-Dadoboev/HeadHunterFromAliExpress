package com.example.headhunterfromaliexpress

import android.app.Application
import com.example.headhunterfromaliexpress.di.DaggerAppComponent

class App : Application() {
    val appComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}