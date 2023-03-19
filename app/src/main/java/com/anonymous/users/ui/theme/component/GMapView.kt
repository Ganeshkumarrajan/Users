package com.anonymous.users.ui.theme.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anonymous.users.ui.theme.UsersTheme
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun GMapView() {
    val singapore = LatLng(1.3554117053046808, 103.86454252780209)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 20f)
    }

    Box() {
        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(
                    color = MaterialTheme.colors.onSurface,
                    shape = RoundedCornerShape(120.dp)
                ),
            cameraPositionState = cameraPositionState

        )
        {

            Circle(
                center = singapore,
                strokeColor = MaterialTheme.colors.primary,
                radius = 15.00
            )

            Marker(
                state = rememberMarkerState(position = singapore),
                title = "Marker1",
                snippet = "Marker in Singapore",
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
            )
        }
    }
}

@Preview
@Composable
fun PreviewGMapView() {
    UsersTheme {
        GMapView()
    }
}
