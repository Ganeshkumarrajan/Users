package com.anonymous.users.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.anonymous.users.R
import com.anonymous.users.presentation.base.UIState
import com.anonymous.users.ui.theme.component.Address
import com.anonymous.users.ui.theme.component.CaptionTitle
import com.anonymous.users.ui.theme.component.FindImageView
import com.anonymous.users.ui.theme.component.GMapView
import com.anonymous.users.ui.theme.component.MobileNumber
import com.anonymous.users.ui.theme.component.Name
import com.anonymous.users.ui.theme.component.StickerItems

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
    Column {
        data?.location?.let {
            GMapView(data.location)
        }

        FindImageView(
            data?.imageURL ?: "", data?.imageText ?: "",
            Modifier.padding(top = 20.dp, start = 7.dp)
        )
        Name(
            text = "${data?.firstName ?: ""} ${data?.secondName ?: ""}",
            modifier = Modifier.padding(top = 24.dp, start = 7.dp)
        )

        data?.stickerItemsProperties?.let {
            StickerItems(
                properties = it,
                modifier = Modifier.padding(top = 10.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 10.dp, start = 7.dp)
        ) {
            CaptionTitle(data?.gender ?: "", Modifier)
            Box(Modifier.padding(start = 10.dp, end = 10.dp)) {
                Divider(
                    Modifier
                        .background(color = MaterialTheme.colors.onBackground)
                        .height(20.dp)
                        .width(2.dp)
                )
            }
            MobileNumber(text = data?.phoneNumber ?: "", modifier = Modifier)
        }
        Address(stringResource(id = R.string.address), Modifier.padding(top = 24.dp, start = 7.dp))
        MobileNumber(data?.address ?: "", Modifier.padding(top = 8.dp, start = 7.dp))
    }
}
