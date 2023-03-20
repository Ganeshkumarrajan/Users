package com.anonymous.users.ui.theme.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LineView() {
    Divider(
        color = MaterialTheme.colors.onBackground.copy(0.5F),
        modifier = Modifier.padding(top = 16.dp)
            .height(1.dp)
            .fillMaxHeight()
    )
}
