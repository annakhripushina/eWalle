package com.example.ewalle.domain.usecase

import com.example.ewalle.data.model.Friend
import com.example.ewalle.domain.repository.UserDataRepository
import javax.inject.Inject

class GetFriendsUseCase @Inject constructor(private val userDataRepository: UserDataRepository) {
    fun getFriends(): List<Friend> = userDataRepository.getFriends()
}