package com.anonymous.users.presentation.details

import com.anonymous.users.domain.details.UserDetailsDomain
import com.anonymous.users.presentation.base.DomainToUIMapper
import com.anonymous.users.ui.theme.component.properties.StickerItemsProperties

class UserDetailsMapperDomainToUI : DomainToUIMapper<UserDetailsDomain?, UserDetailsUI?> {
    override fun map(input: UserDetailsDomain?): UserDetailsUI? =
        input?.let {
            UserDetailsUI(
                it.firstName ?: "", it.secondName,
                it.gender, it.phoneNumber, it.imageURL, StickerItemsProperties(
                    getSticker(it.stickers),
                ), it.address, it.location,
                imageText = getImageText(it.imageURL, it.firstName, it.secondName)
                    ?: ""
            )
        }
}
