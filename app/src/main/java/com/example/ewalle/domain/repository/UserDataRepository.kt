package com.example.ewalle.domain.repository

import com.example.ewalle.data.model.Friend
import com.example.ewalle.data.model.User

interface UserDataRepository {
    fun getUser(): User
    fun getBalance(): String
    fun getFriends(): List<Friend>
}