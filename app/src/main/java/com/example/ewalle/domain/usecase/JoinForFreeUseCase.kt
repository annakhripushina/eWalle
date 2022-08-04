package com.example.ewalle.domain.usecase

import com.example.ewalle.domain.repository.AuthRepository
import javax.inject.Inject

class JoinForFreeUseCase @Inject constructor(private val authRepository: AuthRepository) {
    fun joinForFree(): Boolean = authRepository.joinForFree()
}