package com.anonymous.users.data.deviceHolderList

import com.anonymous.users.data.base.NetworkToDomainMapper
import com.anonymous.users.domain.holderList.DeviceHolderDomain
import javax.inject.Inject

class DeviceHolderListNetworkToDomain @Inject constructor() :
    NetworkToDomainMapper<DeviceHolderNetwork?, List<DeviceHolderDomain>> {
    override fun mapTo(input: DeviceHolderNetwork?): List<DeviceHolderDomain> =
        input?.customers?.map {
            DeviceHolderDomain(
                it?.id ?: 0,
                it?.firstName ?: "",
                it?.lastName ?: "",
                it?.gender ?: "",
                it?.phoneNumber ?: "",
                it?.imageUrl ?: "",
                it?.stickers ?: emptyList()
            )
        } ?: emptyList()
}
