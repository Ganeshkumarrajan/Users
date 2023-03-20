package com.anonymous.users.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.anonymous.users.presentation.base.UIState
import com.anonymous.users.ui.theme.component.*

@Composable
fun DeviceHolderDetailsScreen(userID: String, viewModel: UserDetailsViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .background(color = Color.White)
    ) {
        when (val result = viewModel.userDetails.collectAsState().value) {
            is UIState.Success -> {
                OnSuccess(result.data)
            }
            else -> {}
        }
    }

    viewModel.getDetails(userID)
}

@Composable
private fun OnSuccess(data: UserDetailsUI?) {
    Column() {
        GMapView()
        FindImageView(data?.imageURL ?: "", data?.imageText ?: "")
        Title(text = "${data?.firstName ?: ""} ${data?.secondName}", modifier = Modifier)
        data?.stickerItemsProperties?.let { StickerItems(properties = it) }

        Row() {
            CaptionTitle(data?.gender ?: "", Modifier)
        }


    }
}
