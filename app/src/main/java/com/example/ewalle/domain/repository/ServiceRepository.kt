package com.example.ewalle.domain.repository

import com.example.ewalle.data.model.Service

interface ServiceRepository {
    fun getServices(): List<Service>
}