package com.anonymous.users.data

import com.anonymous.users.domain.DeviceHolderDomain
import com.anonymous.users.domain.DeviceHolderRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeviceHolderRepositoryImpl @Inject constructor(
    private val service: DeviceHolderService,
    private val deviceHolderMapListMapper: NetworkToDomainMapper
    <DeviceHolderNetwork?, List<DeviceHolderDomain>>
) :
    DeviceHolderRepository {
    override suspend fun getDeviceHolders(): List<DeviceHolderDomain> =

        convertToNetworkResult(service.getDeviceHolderList(), deviceHolderMapListMapper)
            ?: emptyList()


}

interface NetworkToDomainMapper<I, O> {
    fun mapTo(input: I): O
}

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

internal fun <I, O> convertToNetworkResult(
    data: ApiResponse<I>,
    mapper: NetworkToDomainMapper<I, O>
): O? {
    var result: O? = null

    data.onSuccess {
        result = mapper.mapTo(this.data)
    }.onError {
        result = null
    }.onException {
        result = null
    }

    return result
}