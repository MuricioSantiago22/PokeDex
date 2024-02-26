package com.mauriciojimenez.pokedex.domain.entities.action.error

sealed interface ErrorStatus {
        object EmptyResponseError : ErrorStatus
        data class NetworkError(val httpStatus: Int) : ErrorStatus
        data class UnknownError(val exception: Exception) : ErrorStatus
}
