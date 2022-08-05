package com.example.ewalle.data.repository

import com.example.ewalle.data.datasource.DataModel
import com.example.ewalle.domain.repository.TemperatureRepository
import javax.inject.Inject

class TemperatureRepositoryImpl @Inject constructor() : TemperatureRepository {
    private val data = DataModel()
    override fun getTemperature(): String = data.temperature
}