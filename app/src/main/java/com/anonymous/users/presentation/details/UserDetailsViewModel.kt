package com.anonymous.users.presentation.details


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anonymous.users.domain.GetUserDetailsUseCase
import com.anonymous.users.domain.base.NetworkResult
import com.anonymous.users.domain.details.UserDetailsDomain
import com.anonymous.users.presentation.base.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val getUserDetailsUseCase: GetUserDetailsUseCase,
    private val mapper: UserDetailsMapperDomainToUI
) : ViewModel() {
    private val _userDetails = MutableStateFlow<UIState<UserDetailsUI?>>(UIState.Nothing())
    val userDetails = _userDetails

    fun getDetails(id: String) {
        viewModelScope.launch {
            getUserDetailsUseCase.invoke(id).collectLatest {
                when (it) {
                    is NetworkResult.Success -> {
                        onSuccess(it.data)
                    }
                    is NetworkResult.Error -> {
                        _userDetails.value = UIState.Error("")
                    }
                }
            }
        }
    }

    private fun onSuccess(data: UserDetailsDomain?) {
        _userDetails.value = UIState.Success(mapper.map(data))
    }
}
