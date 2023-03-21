package com.anonymous.users.presentation.di

import com.anonymous.users.domain.holderList.DeviceHolderDomain
import com.anonymous.users.presentation.base.DomainToUIMapper
import com.anonymous.users.presentation.details.UserDetailsMapperDomainToUI
import com.anonymous.users.presentation.list.DeviceHolderMapperDomainToUi
import com.anonymous.users.ui.theme.component.properties.DeviceHolderItemProperties
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class ViewModuleModule {
    @Provides
    fun provideDeviceHolderUIMapper(): DomainToUIMapper<List<DeviceHolderDomain>, List<DeviceHolderItemProperties>> =
        DeviceHolderMapperDomainToUi()

    @Provides
    fun provideUserDetailsMapper(): UserDetailsMapperDomainToUI = UserDetailsMapperDomainToUI()
}
