package com.example.ewalle.domain.repository

import com.example.ewalle.data.datasource.Services
import java.util.ArrayList

interface ServiceRepository {
    fun getServices() : List<Services>
}