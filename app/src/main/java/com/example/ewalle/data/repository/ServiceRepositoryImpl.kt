package com.example.ewalle.data.repository

import com.example.ewalle.R
import com.example.ewalle.data.datasource.DataModel
import com.example.ewalle.data.datasource.Services
import com.example.ewalle.domain.repository.ServiceRepository
import java.util.ArrayList
import javax.inject.Inject

class ServiceRepositoryImpl @Inject constructor(): ServiceRepository {
    private val data = DataModel()

    override fun getServices(): List<Services> = data.services




}