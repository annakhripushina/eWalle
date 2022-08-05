package com.example.ewalle.domain.usecase

import com.example.ewalle.domain.repository.TemperatureRepository
import javax.inject.Inject

class GetTemperatureUseCase @Inject constructor(private val temperatureRepository: TemperatureRepository) {
    fun getTemperature(): String = temperatureRepository.getTemperature()
}