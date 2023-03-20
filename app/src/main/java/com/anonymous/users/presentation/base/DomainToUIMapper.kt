package com.anonymous.users.presentation.base

import com.anonymous.users.ui.theme.component.properties.StickerValue

interface DomainToUIMapper<I, O> {
    fun map(input: I): O

    fun getImageText(imageURL: String, firstName: String, secondName: String): String? {
        return if (imageURL.isEmpty() && firstName.isNotEmpty() && secondName.isNotEmpty())
            "${firstName[0]}${secondName[0]}"
        else ""
    }

    fun getSticker(data: List<String?>): List<StickerValue> {

        return data.map { value ->
            StickerValue(
                value ?: "",
                value == "Ban"
            )
        }
    }
}
