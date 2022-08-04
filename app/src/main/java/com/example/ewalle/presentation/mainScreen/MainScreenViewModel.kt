package com.example.ewalle.presentation.mainScreen

import androidx.lifecycle.ViewModel
import com.example.ewalle.domain.usecase.*
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val getServicesUseCase: GetServicesMainScreenUseCase
) : ViewModel() {

    fun getServices() = getServicesUseCase.getServices()

}