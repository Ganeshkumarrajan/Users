package com.anonymous.users.ui.theme.component.properties

data class DeviceHolderItemProperties(
    val id: Int,
    val name: String,
    val genderName: String,
    val mobileNumber: String,
    val stickerItemsProperties: StickerItemsProperties,
    val imageURL: String? = null,
    val imageText: String? = null
)
