package com.example.ewalle

import android.app.Application
import com.example.ewalle.di.AppComponent
import com.example.ewalle.di.DaggerAppComponent

class App : Application() {
    val appComponent: AppComponent = DaggerAppComponent.create()
}