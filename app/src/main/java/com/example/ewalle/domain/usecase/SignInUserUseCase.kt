package com.example.ewalle.domain.usecase

import com.example.ewalle.domain.repository.AuthRepository
import javax.inject.Inject

class SignInUserUseCase @Inject constructor(private val authRepository: AuthRepository) {
    fun signInUser(): Boolean = authRepository.signInUser()
}