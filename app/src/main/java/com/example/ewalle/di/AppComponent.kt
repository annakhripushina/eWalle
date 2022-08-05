package com.example.ewalle.di

import com.example.ewalle.di.module.DataModule
import com.example.ewalle.di.module.DomainModule
import com.example.ewalle.ui.MainActivity
import com.example.ewalle.ui.login.LoginFragment
import com.example.ewalle.ui.mainScreen.MainScreenFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(loginFragment: LoginFragment)
    fun inject(mainScreenFragment: MainScreenFragment)
    fun inject(mainActivity: MainActivity)
}