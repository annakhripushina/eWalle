package com.example.ewalle.domain.usecase

import com.example.ewalle.data.repository.DateTimeRepositoryImpl
import com.example.ewalle.domain.repository.DateTimeRepository
import javax.inject.Inject

class GetDateTimeUseCase @Inject constructor(private val dateTimeRepository: DateTimeRepository){
    fun getDate(): String = dateTimeRepository.getDate()

    fun getTime(): String = dateTimeRepository.getTime()

}