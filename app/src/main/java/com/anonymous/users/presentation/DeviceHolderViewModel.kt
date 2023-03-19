package com.anonymous.users.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anonymous.users.domain.DeviceHolderDomain
import com.anonymous.users.domain.GetDeviceHoldersUseCase
import com.anonymous.users.domain.NetworkResult
import com.anonymous.users.ui.theme.component.properties.DeviceHolderItemProperties
import com.anonymous.users.ui.theme.component.properties.StickerItemsProperties
import com.anonymous.users.ui.theme.component.properties.StickerValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeviceHolderViewModel @Inject constructor(
    private val useCase: GetDeviceHoldersUseCase,
    private val mapper: DeviceHolderMapperDomainToUi
) : ViewModel() {
    private val _holders =
        MutableStateFlow<UIState<List<DeviceHolderItemProperties>>>(UIState.Nothing())
    val holders: StateFlow<UIState<List<DeviceHolderItemProperties>>> = _holders

    init {
        viewModelScope.launch {
            useCase.invoke().collectLatest {
                when (it) {
                    is NetworkResult.Success -> {
                        parseDeviceHolderList(it.data)
                    }
                    is NetworkResult.Error -> {
                        handleError()
                    }
                }
            }

        }
    }

    private fun parseDeviceHolderList(data: List<DeviceHolderDomain>) {
        _holders.value = UIState.Success(mapper.map(data))
    }

    private fun handleError() {
        _holders.value = UIState.Error("")
    }
}

interface DomainToUIMapper<I, O> {
    fun map(input: I): O
}

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
                it.imageURL,getImageText(it.imageURL,it.firstName,it.secondName))
        }


    private fun getSticker(data: List<String?>): List<StickerValue> {

        return data.map { value ->
            StickerValue(
                value ?: "",
               value == "Ban"
            )
        }

    }

    private fun getImageText(imageURL: String, firstName: String, secondName: String): String? {
        return if (imageURL.isEmpty() && firstName.isNotEmpty() && secondName.isNotEmpty())
            "${firstName[0]}${secondName[0]}"
        else ""
    }

}

sealed class UIState<T> {
    class Nothing<T> : UIState<T>()
    data class Success<T>(val data: T) : UIState<T>()
    data class Error<T>(val message: String) : UIState<T>()
}