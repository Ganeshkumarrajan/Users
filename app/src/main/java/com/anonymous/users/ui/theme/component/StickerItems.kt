package com.anonymous.users.ui.theme.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anonymous.users.ui.theme.UsersTheme
import com.anonymous.users.ui.theme.component.properties.StickerItemsProperties
import com.anonymous.users.ui.theme.component.properties.StickerValue

@Composable
fun StickerItems(properties: StickerItemsProperties) {
    LazyRow() {
        items(properties.defaultNames) { sticker ->
            Box(modifier = Modifier.padding(start = 8.dp)) {
                if (sticker.isSelected) {
                    SelectedStickersName(sticker.name, modifier = Modifier)
                } else {
                    StickersName(name = sticker.name, modifier = Modifier)
                }
            }

        }
    }
}

@Preview
@Composable
fun PreviewStickerItems() {
    UsersTheme {
        StickerItems(
            properties =
            StickerItemsProperties(
                listOf(
                    StickerValue("Fam", false),
                    StickerValue("Ban", true)
                )
            )
        )
    }
}
