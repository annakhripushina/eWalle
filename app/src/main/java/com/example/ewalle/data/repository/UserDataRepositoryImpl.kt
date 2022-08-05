package com.example.ewalle.data.repository

import com.example.ewalle.data.datasource.DataModel
import com.example.ewalle.data.model.Friend
import com.example.ewalle.data.model.User
import com.example.ewalle.domain.repository.UserDataRepository
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor() : UserDataRepository {
    private val data = DataModel()

    override fun getUser(): User = data.user

    override fun getBalance(): String = data.balance

    override fun getFriends(): List<Friend> = data.friends
}