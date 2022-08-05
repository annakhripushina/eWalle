package com.example.ewalle.domain.usecase

import com.example.ewalle.domain.repository.AuthRepository
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(private val authRepository: AuthRepository) {
    fun createUser(): Boolean = authRepository.createUser()
}