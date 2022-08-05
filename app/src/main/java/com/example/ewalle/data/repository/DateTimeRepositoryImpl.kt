package com.example.ewalle.data.repository

import com.example.ewalle.domain.repository.DateTimeRepository
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateTimeRepositoryImpl @Inject constructor() : DateTimeRepository {
    override fun getDate(): String =
        SimpleDateFormat("MMM.dd.yyyy|EEEE", Locale.US).format(System.currentTimeMillis())

    override fun getTime(): String =
        SimpleDateFormat("hh:mm a", Locale.US).format(System.currentTimeMillis())

}