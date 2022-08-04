package com.example.ewalle.data.repository

import com.example.ewalle.data.datasource.DataModel
import com.example.ewalle.domain.repository.DateTimeRepository
import javax.inject.Inject

class DateTimeRepositoryImpl @Inject constructor(): DateTimeRepository {
    private val data = DataModel()
    override fun getDate(): String = data.date
    override fun getTime(): String = data.time
}