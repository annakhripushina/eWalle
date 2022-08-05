package com.example.ewalle.data.repository

import com.example.ewalle.data.datasource.DataModel
import com.example.ewalle.data.model.Service
import com.example.ewalle.domain.repository.ServiceRepository
import javax.inject.Inject

class ServiceRepositoryImpl @Inject constructor() : ServiceRepository {
    private val data = DataModel()

    override fun getServices(): List<Service> = data.services


}