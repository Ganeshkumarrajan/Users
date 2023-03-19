package com.anonymous.users.presentation.di

import com.anonymous.users.data.DeviceHolderRepositoryImpl
import com.anonymous.users.domain.GetDeviceHoldersUseCase
import com.anonymous.users.domain.GetDeviceHoldersUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {
    @Provides
    fun provideGetDeviceHolderUseCase(deviceHolderRepositoryImpl: DeviceHolderRepositoryImpl): GetDeviceHoldersUseCase =
        GetDeviceHoldersUseCaseImpl(deviceHolderRepositoryImpl)
}
