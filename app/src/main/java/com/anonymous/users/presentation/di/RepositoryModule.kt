package com.anonymous.users.presentation.di


import com.anonymous.users.data.*
import com.anonymous.users.domain.DeviceHolderDomain
import com.anonymous.users.domain.DeviceHolderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    fun provideDeviceHolderListNetworkToDomain(): NetworkToDomainMapper<DeviceHolderNetwork?, List<DeviceHolderDomain>> =
        DeviceHolderListNetworkToDomain()

    @Provides
    fun provideDeviceHolderRepository(
        mapper: DeviceHolderListNetworkToDomain,
        deviceHolderService: DeviceHolderService
    ): DeviceHolderRepository =
        DeviceHolderRepositoryImpl(deviceHolderService, mapper)

}
