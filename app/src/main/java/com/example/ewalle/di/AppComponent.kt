package com.example.ewalle.di

import com.example.ewalle.di.module.DomainModule
import com.example.ewalle.ui.LoginFragment
import com.example.ewalle.ui.MainScreenFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DomainModule::class])
interface AppComponent {
    fun inject(loginFragment: LoginFragment)
    fun inject(mainScreenFragment: MainScreenFragment)
}