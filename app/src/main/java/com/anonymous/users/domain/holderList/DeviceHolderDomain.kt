package com.anonymous.users.domain.holderList

import com.google.android.gms.maps.model.LatLng

data class DeviceHolderDomain(
    val id: Int,
    val firstName: String,
    val secondName: String,
    val gender: String,
    val phoneNumber: String,
    val imageURL: String,
    val stickers: List<String?>
)
