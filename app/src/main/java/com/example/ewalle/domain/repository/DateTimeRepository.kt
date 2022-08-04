package com.example.ewalle.domain.repository

interface DateTimeRepository {
    fun getDate() : String
    fun getTime() : String
}