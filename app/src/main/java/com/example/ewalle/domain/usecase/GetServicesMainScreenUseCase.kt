package com.example.ewalle.domain.usecase

import com.example.ewalle.R
import com.example.ewalle.data.datasource.Services
import com.example.ewalle.domain.repository.DateTimeRepository
import com.example.ewalle.domain.repository.ServiceRepository
import java.util.ArrayList
import javax.inject.Inject

class GetServicesMainScreenUseCase @Inject constructor(private val serviceRepository: ServiceRepository){

    fun getServices(): List<Services> {
        val serviceList : MutableList<Services> = serviceRepository.getServices().toMutableList()
        if (serviceRepository.getServices().size >= 8) {
            for (i in 0 until 7){
                serviceList.add(serviceRepository.getServices()[i])
            }
        }
        serviceList.add(Services("More Options", R.drawable.ic_more_options))
        return serviceList
    }

}