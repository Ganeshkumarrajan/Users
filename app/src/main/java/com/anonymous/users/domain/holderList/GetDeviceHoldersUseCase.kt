package com.anonymous.users.domain.holderList

import com.anonymous.users.domain.base.NetworkResult
import com.anonymous.users.domain.repository.DeviceHolderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface GetDeviceHoldersUseCase {
    suspend fun invoke(): Flow<NetworkResult<List<DeviceHolderDomain>>>
}

class GetDeviceHoldersUseCaseImpl(private val repository: DeviceHolderRepository) :
    GetDeviceHoldersUseCase {
    override suspend fun invoke(): Flow<NetworkResult<List<DeviceHolderDomain>>> =
        flow<NetworkResult<List<DeviceHolderDomain>>> {
            emit(NetworkResult.Success(repository.getDeviceHolders()))
        }.catch {
            emit(NetworkResult.Error())
        }.flowOn(Dispatchers.IO)
}
