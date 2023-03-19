package com.anonymous.users.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.anonymous.users.ui.theme.UsersTheme
import com.anonymous.users.ui.theme.component.properties.UserImageProperties

@Composable
fun UserImage(properties: UserImageProperties) {
    Image(
        painter = rememberAsyncImagePainter(properties.url),
        contentDescription = null,
        modifier = Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(24.dp))
    )

}

@Preview
@Composable
fun PreviewUserImage() {
    UsersTheme() {
        UserImage(
            properties = UserImageProperties("https://fastly.picsum.photos/id/445/400/400.jpg?hmac=CCjqlZXQQ_5kl0X6naMjQKUWSbQloDYImyB9zGFOA8M"),
        )
    }
}
