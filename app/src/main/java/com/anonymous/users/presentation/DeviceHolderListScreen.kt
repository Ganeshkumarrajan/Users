package com.anonymous.users.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.anonymous.users.ui.theme.component.DeviceHolderItem
import com.anonymous.users.ui.theme.component.properties.DeviceHolderItemProperties

@Composable
fun DeviceHolderListScreen(
    navController: NavController,
    viewModel: DeviceHolderViewModel = hiltViewModel()
) {
    Column(modifier = Modifier
        .padding(10.dp)
        .background(color = Color.White)) {
        when (val result = viewModel.holders.collectAsState().value) {
            is UIState.Success -> {
                OnSuccess(result.data)
            }
            else -> {}
        }
    }


}


@Composable
private fun OnSuccess(data: List<DeviceHolderItemProperties>) {
    LazyColumn() {
        items(data) { holder ->
            Column(Modifier.background(color = Color.White)) {
                DeviceHolderItem(properties = holder) {

                }
            }
        }
    }
}