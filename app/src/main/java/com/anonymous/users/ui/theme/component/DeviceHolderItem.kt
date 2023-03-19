package com.anonymous.users.ui.theme.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anonymous.users.ui.theme.UsersTheme
import com.anonymous.users.ui.theme.component.properties.DeviceHolderItemProperties
import com.anonymous.users.ui.theme.component.properties.StickerItemsProperties
import com.anonymous.users.ui.theme.component.properties.StickerValue
import com.anonymous.users.ui.theme.component.properties.UserImageProperties

@Composable
fun DeviceHolderItem(properties: DeviceHolderItemProperties) {
    Box(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier.padding(top = 16.dp, bottom = 1.dp, start = 5.dp, end = 5.dp)
        ) {


            Row(
                verticalAlignment = Alignment.CenterVertically,

            ) {

                if (properties.imageURL?.isNotEmpty() == true) {
                    UserImage(UserImageProperties(properties.imageURL))
                }

                if (properties.imageText?.isNotEmpty() == true) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .size(48.dp)
                            .background(
                                color = MaterialTheme.colors.onSurface,
                                shape = RoundedCornerShape(24.dp)
                            ),
                    ) {
                        TextImage(
                            name = properties.imageText,
                            modifier = Modifier.wrapContentSize()
                        )
                    }
                }

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
