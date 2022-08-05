package com.example.ewalle.presentation

import androidx.lifecycle.ViewModel
import com.example.ewalle.domain.usecase.GetUserUseCase
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    fun getUser() = getUserUseCase.getUser()
}