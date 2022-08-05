package com.example.ewalle.presentation.mainScreen

import androidx.lifecycle.ViewModel
import com.example.ewalle.domain.usecase.GetBalanceUseCase
import com.example.ewalle.domain.usecase.GetFriendsUseCase
import com.example.ewalle.domain.usecase.GetServicesMainScreenUseCase
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val getServicesUseCase: GetServicesMainScreenUseCase,
    private val getBalanceUseCase: GetBalanceUseCase,
    private val getFriendsUseCase: GetFriendsUseCase
) : ViewModel() {

    fun getFriends() = getFriendsUseCase.getFriends()

    fun getBalance() = getBalanceUseCase.getBalance()

    fun getServices() = getServicesUseCase.getServices()

}