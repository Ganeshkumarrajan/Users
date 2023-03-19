package com.anonymous.users.data

data class DeviceHolderNetwork(
    val customers: List<Customer?>?
)

data class Customer(
    val firstName: String?,
    val gender: String?,
    val id: Int?,
    val imageUrl: String?,
    val lastName: String?,
    val phoneNumber: String?,
    val stickers: List<String?>?
)
