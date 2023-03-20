package com.anonymous.users.data.base

interface NetworkToDomainMapper<I, O> {
    fun mapTo(input: I): O
}
