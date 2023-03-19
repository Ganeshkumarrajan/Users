package com.anonymous.users.data

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface DeviceHolderService {
    @GET("users")
    suspend fun getDeviceHolderList(): ApiResponse<DeviceHolderNetwork>
}
