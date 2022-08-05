package com.example.ewalle.domain.usecase

import com.example.ewalle.domain.repository.UserDataRepository
import javax.inject.Inject

class GetBalanceUseCase @Inject constructor(private val userDataRepository: UserDataRepository) {
    fun getBalance(): String = userDataRepository.getBalance()
}