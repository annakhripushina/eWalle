package com.example.ewalle.domain.usecase

import android.content.Context
import com.example.ewalle.R
import com.example.ewalle.data.model.Service
import com.example.ewalle.domain.repository.ServiceRepository
import javax.inject.Inject

class GetServicesMainScreenUseCase @Inject constructor(
    private val serviceRepository: ServiceRepository,
    private val context: Context
) {

    fun getServices(): List<Service> {
        val serviceList: MutableList<Service> = serviceRepository.getServices().toMutableList()
        if (serviceRepository.getServices().size >= 8) {
            for (i in 0 until 7) {
                serviceList.add(serviceRepository.getServices()[i])
            }
        }
        serviceList.add(
            Service(
                context.getString(R.string.moreOptions),
                R.drawable.ic_more_options
            )
        )
        return serviceList
    }

}