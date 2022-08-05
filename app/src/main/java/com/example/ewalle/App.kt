package com.example.ewalle

import android.app.Application
import com.example.ewalle.di.AppComponent
import com.example.ewalle.di.DaggerAppComponent
import com.example.ewalle.di.module.DataModule

class App : Application() {
    val appComponent: AppComponent =
        DaggerAppComponent.builder()
            .dataModule(DataModule(this))
            .build()
}