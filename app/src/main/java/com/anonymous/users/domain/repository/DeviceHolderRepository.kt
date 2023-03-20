package com.anonymous.users.domain.repository

import com.anonymous.users.domain.details.UserDetailsDomain
import com.anonymous.users.domain.holderList.DeviceHolderDomain

interface DeviceHolderRepository {
    suspend fun getDeviceHolders(): List<DeviceHolderDomain>
    suspend fun getUserDetails(id: String): UserDetailsDomain?
}
