package com.example.ewalle.data.datasource

import com.example.ewalle.R
import com.example.ewalle.data.model.Friend
import com.example.ewalle.data.model.Service
import com.example.ewalle.data.model.User

class DataModel(
    val temperature: String = "34\u00B0 C",
    val balance: String = "20,600",
    val friends: List<Friend> = listOf(
        Friend(
            "Mike",
            R.drawable.ic_mike
        ),
        Friend(
            "Joshpeh",
            R.drawable.ic_joshpeh
        ),
        Friend(
            "Ashley",
            R.drawable.ic_ashley
        ),
    ),
    val services: List<Service> = listOf(
        Service("Send Money", R.drawable.ic_send_money),
        Service("Receive Money", R.drawable.ic_receive_money),
        Service("Mobile Prepaid", R.drawable.ic_mobile_prepaid),
        Service("Electricity Bill", R.drawable.ic_electricity_bill),
        Service("Cashback Offer", R.drawable.ic_cashback_offer),
        Service("Movie Tickets", R.drawable.ic_movie_tickets),
        Service("Flight Tickets", R.drawable.ic_flight_tickets),
    ),
    val user: User = User("Carol Black", "Seattle,Washington", R.drawable.ic_carol)
)


