package com.anonymous.users.presentation.di

import com.anonymous.users.presentation.details.UserDetailsMapperDomainToUI
import com.anonymous.users.presentation.list.DeviceHolderMapperDomainToUi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class ViewModuleModule {
    @Provides
    fun provideDeviceHolderUIMapper(): DeviceHolderMapperDomainToUi =
        DeviceHolderMapperDomainToUi()

    @Provides
    fun provideUserDetailsMapper(): UserDetailsMapperDomainToUI = UserDetailsMapperDomainToUI()
}
