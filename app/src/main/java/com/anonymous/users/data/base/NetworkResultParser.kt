package com.anonymous.users.data.base

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess

internal fun <I, O> convertToNetworkResult(
    data: ApiResponse<I>,
    mapper: NetworkToDomainMapper<I, O>
): O? {
    var result: O? = null

    data.onSuccess {
        result = mapper.mapTo(this.data)
    }.onError {
        result = null
    }.onException {
        result = null
    }

    return result
}
