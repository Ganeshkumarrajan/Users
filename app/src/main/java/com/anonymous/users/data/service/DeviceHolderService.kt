package com.anonymous.users.data.service

import com.anonymous.users.data.details.UserDetailsNetwork
import com.anonymous.users.data.deviceHolderList.DeviceHolderNetwork
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DeviceHolderService {
    @GET("users")
    suspend fun getDeviceHolderList(): ApiResponse<DeviceHolderNetwork>

    @GET("users/{id}")
    suspend fun getUserDetails(@Path("id") id: String): ApiResponse<UserDetailsNetwork>
}
