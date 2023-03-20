package com.anonymous.users.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anonymous.users.domain.holderList.DeviceHolderDomain
import com.anonymous.users.domain.holderList.GetDeviceHoldersUseCase
import com.anonymous.users.domain.base.NetworkResult
import com.anonymous.users.presentation.base.UIState
import com.anonymous.users.presentation.list.DeviceHolderMapperDomainToUi
import com.anonymous.users.ui.theme.component.properties.DeviceHolderItemProperties
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
