package com.anonymous.users.presentation.list

import com.anonymous.users.domain.holderList.DeviceHolderDomain
import com.anonymous.users.presentation.base.DomainToUIMapper
import com.anonymous.users.ui.theme.component.properties.DeviceHolderItemProperties
import com.anonymous.users.ui.theme.component.properties.StickerItemsProperties

class DeviceHolderMapperDomainToUi :
    DomainToUIMapper<List<DeviceHolderDomain>, List<DeviceHolderItemProperties>> {
    override fun map(input: List<DeviceHolderDomain>): List<DeviceHolderItemProperties> =
        input.map {
            DeviceHolderItemProperties(
                it.id,
                "${it.firstName} ${it.secondName}",
                it.gender,
                it.phoneNumber,
                StickerItemsProperties(
                    getSticker(it.stickers),
                ),
                it.imageURL, getImageText(it.imageURL, it.firstName, it.secondName)
            )
        }
}
