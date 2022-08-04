package com.example.ewalle.presentation.login

import androidx.lifecycle.ViewModel
import com.example.ewalle.domain.usecase.*
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val getDateTimeUseCase: GetDateTimeUseCase,
    private val getTemperatureUseCase: GetTemperatureUseCase,
    private val signInUserUseCase: SignInUserUseCase,
    private val createUserUseCase: CreateUserUseCase,
    private val joinForFreeUseCase: JoinForFreeUseCase
) : ViewModel() {

    fun getDate(): String = getDateTimeUseCase.getDate()

    fun getTime(): String = getDateTimeUseCase.getTime()

    fun getTemperature(): String = getTemperatureUseCase.getTemperature()

    fun signInUser() : Boolean = signInUserUseCase.signInUser()

    fun createUser() : Boolean = createUserUseCase.createUser()

    fun joinForFree() : Boolean = joinForFreeUseCase.joinForFree()
}