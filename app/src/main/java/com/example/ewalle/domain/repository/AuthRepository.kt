package com.example.ewalle.domain.repository

interface AuthRepository {
    fun signInUser(): Boolean
    fun createUser(): Boolean
    fun joinForFree(): Boolean
}