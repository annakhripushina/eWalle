package com.example.ewalle.data.datasource

import com.example.ewalle.R

class DataModel(
    val time: String = "06:20 PM",
    val date: String = "Nov.10.2020",
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
    val services: List<Services> = listOf(
        Services("Send Money", R.drawable.ic_send_money),
        Services("Receive Money", R.drawable.ic_receive_money),
        Services("Mobile Prepaid", R.drawable.ic_mobile_prepaid),
        Services("Electricity Bill", R.drawable.ic_electricity_bill),
        Services("Cashback Offer", R.drawable.ic_cashback_offer),
        Services("Movie Tickets", R.drawable.ic_movie_tickets),
        Services("Flight Tickets", R.drawable.ic_flight_tickets),
    ),
    val user: User = User("Carol Black", "Seattle,Washington", R.drawable.ic_carol),
    val menuItems: List<String> = listOf("Home", "Profile", "Accounts", "Transactions", "Stats", "Settings", "Help"),
    val logoutTitle: String = "Logout",
    val version: String = "Version 2.0.1",
)

class Services(
    val name: String,
    val image: Int,
)

class Friend(
    val name: String,
    val image: Int,
)

class User(
    val name: String,
    val address: String,
    val image: Int,
)

