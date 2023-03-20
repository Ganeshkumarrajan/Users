package com.anonymous.users.domain.details

import com.google.android.gms.maps.model.LatLng

data class UserDetailsDomain(
    val firstName: String,
    val secondName: String,
    val gender: String,
    val phoneNumber: String,
    val imageURL: String,
    val stickers: List<String?>,
    val address: String?,
    val location: LatLng?
)