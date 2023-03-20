package com.anonymous.users.data.details

data class UserDetailsNetwork(
    val address: Address?,
    val currentLatitude: Double?,
    val currentLongitude: Double?,
    val firstName: String?,
    val gender: String?,
    val id: Int?,
    val imageUrl: String?,
    val lastName: String?,
    val phoneNumber: String?,
    val stickers: List<String?>?
)

data class Address(
    val city: String?,
    val country: String?,
    val state: String?,
    val street: String?,
    val zip: String?
) {
    override fun toString(): String =
        "$street $city $state $zip $country"
}
