package com.example.ewalle.data.repository

import com.example.ewalle.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(): AuthRepository{
    override fun signInUser(): Boolean = true
    override fun createUser(): Boolean = true
    override fun joinForFree(): Boolean = true
}