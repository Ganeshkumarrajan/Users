package com.anonymous.users.data.GeoLocation

import android.app.Application
import android.content.Context
import android.location.Address
import android.location.Geocoder
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.firestore.GeoPoint
import java.io.IOException


interface GeoLocation {
    fun convertToLatLan(address: String): LatLng?
}

@Suppress("DEPRECATION")
class GeoLocationImpl(private val context: Context) : GeoLocation {
    override fun convertToLatLan(adr: String): LatLng? {
        val coder = Geocoder(context)
        val address: List<Address>?
        var p1: GeoPoint?

        try {
            address = coder.getFromLocationName(adr, 1)
            if (address == null) {
                return null
            }
            val location: Address = address[0]

            p1 = GeoPoint(
                (location.latitude * 1E6),
                (location.longitude * 1E6)
            )
            return LatLng(p1.latitude, p1.longitude)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

}