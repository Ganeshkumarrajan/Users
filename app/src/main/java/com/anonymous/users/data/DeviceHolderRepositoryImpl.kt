package com.anonymous.users.data

import com.anonymous.users.data.base.NetworkToDomainMapper
import com.anonymous.users.data.base.convertToNetworkResult
import com.anonymous.users.data.details.UserDetailsNetwork
import com.anonymous.users.data.deviceHolderList.DeviceHolderNetwork
import com.anonymous.users.data.service.DeviceHolderService
import com.anonymous.users.domain.details.UserDetailsDomain
import com.anonymous.users.domain.holderList.DeviceHolderDomain
import com.anonymous.users.domain.repository.DeviceHolderRepository
import javax.inject.Inject

class DeviceHolderRepositoryImpl @Inject constructor(
    private val service: DeviceHolderService,
    private val deviceHolderMapListMapper: NetworkToDomainMapper<DeviceHolderNetwork?, List<DeviceHolderDomain>>,
    private val userDetailsMapper: NetworkToDomainMapper<UserDetailsNetwork, UserDetailsDomain>,
) :
    DeviceHolderRepository {
    override suspend fun getDeviceHolders(): List<DeviceHolderDomain> =

        convertToNetworkResult(service.getDeviceHolderList(), deviceHolderMapListMapper)
            ?: emptyList()

    override suspend fun getUserDetails(id: String): UserDetailsDomain? =
        convertToNetworkResult(service.getUserDetails(id), userDetailsMapper)
}
