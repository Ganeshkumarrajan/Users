package com.anonymous.users.ui.theme.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anonymous.users.ui.theme.UsersTheme
import com.anonymous.users.ui.theme.component.properties.DeviceHolderItemProperties
import com.anonymous.users.ui.theme.component.properties.StickerItemsProperties
import com.anonymous.users.ui.theme.component.properties.StickerValue

@Composable
fun DeviceHolderItem(
    properties: DeviceHolderItemProperties,
    onItemSelected: ((Int) -> Unit?)? = null
) {
    Box(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 1.dp, start = 5.dp, end = 5.dp)
                .clickable {
                    onItemSelected?.invoke(properties.id)
                }
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                FindImageView(properties.imageURL ?: "", properties.imageText ?: "")

                Column(Modifier.padding(start = 12.dp)) {

                    Row {
                        Title(properties.name, Modifier)
                        CaptionTitle(properties.genderName, Modifier.padding(start = 8.dp))
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 4.dp)
                    ) {
                        MobileNumber(properties.mobileNumber, Modifier)
                        StickerItems(properties = properties.stickerItemsProperties)
                    }
                }
            }

            LineView()
        }
    }
}

@Preview
@Composable
fun PreViewDeviceHolderItem() {
    UsersTheme() {
        Column() {

            DeviceHolderItem(
                DeviceHolderItemProperties(
                    1, "Savannah Nguyen", "Male",
                    "123123123123",
                    stickerItemsProperties = StickerItemsProperties(
                        listOf(
                            StickerValue("Fam", false),
                            StickerValue("Ban", true)
                        )
                    ),
                    imageText = "SN"
                )
            )

            DeviceHolderItem(
                DeviceHolderItemProperties(
                    1, "Kristin Watson", "Female",
                    "123123123123",
                    stickerItemsProperties = StickerItemsProperties(
                        listOf(
                            StickerValue("Fam", true),
                            StickerValue("Ban", false)
                        )
                    ),
                    imageText = "KW"
                )
            )
        }
    }
}
