package com.anonymous.users.data.details

import com.anonymous.users.data.GeoLocation.GeoLocation
import com.anonymous.users.data.base.NetworkToDomainMapper
import com.anonymous.users.domain.details.UserDetailsDomain
import javax.inject.Inject

class UserDetailsNetworkToDomainMapper @Inject constructor(private val location: GeoLocation) :
    NetworkToDomainMapper<UserDetailsNetwork, UserDetailsDomain> {
    override fun mapTo(input: UserDetailsNetwork): UserDetailsDomain {
        val location = location.convertToLatLan(input.address.toString())
        return UserDetailsDomain(
            input.firstName ?: "",
            input.lastName ?: "",
            input.gender ?: "",
            input.phoneNumber ?: "",
            input.imageUrl ?: "",
            input.stickers ?: emptyList(),
            input.address.toString(),
            location
        )
    }
}
