package com.example.ewalle.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule(val application: Application) {
    @Singleton
    @Provides
    fun provideAppContext(): Context =
        application.applicationContext
}