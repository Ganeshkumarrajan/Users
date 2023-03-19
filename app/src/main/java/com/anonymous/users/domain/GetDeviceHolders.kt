package com.anonymous.users.domain

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


interface DeviceHolderRepository {
    suspend fun getDeviceHolders(): List<DeviceHolderDomain>
}

sealed class NetworkResult<T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    class Error<T>() : NetworkResult<T>()
}
