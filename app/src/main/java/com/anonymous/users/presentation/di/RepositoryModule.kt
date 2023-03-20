package com.anonymous.users.presentation.di

import android.app.Application
import com.anonymous.users.data.DeviceHolderRepositoryImpl
import com.anonymous.users.data.base.NetworkToDomainMapper
import com.anonymous.users.data.details.UserDetailsNetwork
import com.anonymous.users.data.details.UserDetailsNetworkToDomainMapper
import com.anonymous.users.data.deviceHolderList.DeviceHolderListNetworkToDomain
import com.anonymous.users.data.deviceHolderList.DeviceHolderNetwork
import com.anonymous.users.data.geoLocation.GeoLocation
import com.anonymous.users.data.geoLocation.GeoLocationImpl
import com.anonymous.users.data.service.DeviceHolderService
import com.anonymous.users.domain.details.UserDetailsDomain
import com.anonymous.users.domain.holderList.DeviceHolderDomain
import com.anonymous.users.domain.repository.DeviceHolderRepository
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
    fun provideGeoConverter(context: Application): GeoLocation =
        GeoLocationImpl(context)

    @Provides
    fun provideUserDetailsNetworkToDomain(location: GeoLocation): NetworkToDomainMapper<UserDetailsNetwork, UserDetailsDomain> =
        UserDetailsNetworkToDomainMapper(location)

    @Provides
    fun provideDeviceHolderRepository(
        mapper: DeviceHolderListNetworkToDomain,
        deviceHolderService: DeviceHolderService,
        userDetailsNetworkToDomainMapper: UserDetailsNetworkToDomainMapper
    ): DeviceHolderRepository =
        DeviceHolderRepositoryImpl(deviceHolderService, mapper, userDetailsNetworkToDomainMapper)
}
