package com.anonymous.users.data.geoLocation

import android.content.Context
import android.location.Address
import android.location.Geocoder
import com.google.android.gms.maps.model.LatLng
import java.io.IOException

interface GeoLocation {
    fun convertToLatLan(address: String): LatLng?
}

@Suppress("DEPRECATION")
class GeoLocationImpl(private val context: Context) : GeoLocation {
    override fun convertToLatLan(address: String): LatLng? {
        val coder = Geocoder(context)
        val addressList: List<Address>?

        try {
            addressList = coder.getFromLocationName(address, 1)

            if (addressList == null) {
                return null
            }

            val location: Address = addressList[0]

            return LatLng(location.latitude, location.longitude)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}
