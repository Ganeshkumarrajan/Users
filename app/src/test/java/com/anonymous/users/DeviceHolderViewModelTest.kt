package com.anonymous.users

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anonymous.users.domain.base.NetworkResult
import com.anonymous.users.domain.holderList.DeviceHolderDomain
import com.anonymous.users.domain.holderList.GetDeviceHoldersUseCase
import com.anonymous.users.presentation.base.DomainToUIMapper
import com.anonymous.users.presentation.base.UIState
import com.anonymous.users.presentation.list.DeviceHolderViewModel
import com.anonymous.users.ui.theme.component.properties.DeviceHolderItemProperties
import com.anonymous.users.ui.theme.component.properties.StickerItemsProperties
import com.anonymous.users.ui.theme.component.properties.StickerValue
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class DeviceHolderViewModelTest {
    private val userListUseCase: GetDeviceHoldersUseCase = mockk()
    private lateinit var viewModel: DeviceHolderViewModel
    private val mapper: DomainToUIMapper<List<DeviceHolderDomain>, List<DeviceHolderItemProperties>> =
        mockk()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getPostWithDetailsSuccessCase() {
        runTest {

            coEvery {
                userListUseCase.invoke()
            } returns getFakeUserListResult()

            coEvery {
                mapper.map(getFakeUserListDomain())
            } returns getFakePostDetailsWithCommentsUI()

            viewModel = DeviceHolderViewModel(userListUseCase, mapper)

            assert(viewModel.holders.value is UIState.Success)
        }
    }

    private suspend fun getFakeUserListResult(): Flow<NetworkResult<List<DeviceHolderDomain>>> =
        flow {
            emit(NetworkResult.Success(getFakeUserListDomain()))
        }

    private fun getFakeUserListDomain(): List<DeviceHolderDomain> =
        listOf(
            DeviceHolderDomain(
                1,
                "name",
                "lastName",
                "Male",
                "24234",
                "imageURL",
                listOf("Fam")
            )
        )

    private fun getFakePostDetailsWithCommentsUI():
        List<DeviceHolderItemProperties> =
        listOf(
            DeviceHolderItemProperties(
                1, "name", "lastName", "24234",
                stickerItemsProperties =
                StickerItemsProperties(listOf(StickerValue("name", true))),
                "imageURL"
            )
        )
}
