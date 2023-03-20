package com.anonymous.users.presentation.details

import com.anonymous.users.ui.theme.component.properties.StickerItemsProperties
import com.google.android.gms.maps.model.LatLng

data class UserDetailsUI(
    val firstName: String,
    val secondName: String,
    val gender: String,
    val phoneNumber: String,
    val imageURL: String,
    val stickerItemsProperties: StickerItemsProperties,
    val address: String?,
    val location: LatLng?,
    val imageText: String
)
