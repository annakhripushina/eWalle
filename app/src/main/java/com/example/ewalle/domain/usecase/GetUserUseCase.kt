package com.example.ewalle.domain.usecase

import com.example.ewalle.data.model.User
import com.example.ewalle.domain.repository.UserDataRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userDataRepository: UserDataRepository) {
    fun getUser(): User = userDataRepository.getUser()
}