package com.anonymous.users.domain

import com.anonymous.users.domain.base.NetworkResult
import com.anonymous.users.domain.details.UserDetailsDomain
import com.anonymous.users.domain.repository.DeviceHolderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface GetUserDetailsUseCase {
    suspend fun invoke(id: String): Flow<NetworkResult<UserDetailsDomain?>>
}

class GetUserDetailsUseCaseImpl(private val repository: DeviceHolderRepository) :
    GetUserDetailsUseCase {
    override suspend fun invoke(id: String): Flow<NetworkResult<UserDetailsDomain?>> =
        flow<NetworkResult<UserDetailsDomain?>> {
            emit(NetworkResult.Success(repository.getUserDetails(id)))
        }.catch {
            it.localizedMessage
            emit(NetworkResult.Error())
        }.flowOn(Dispatchers.IO)

}