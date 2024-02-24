package com.mauriciojimenez.pokedex.domain.entities.action.error

interface ErrorEntity {
    sealed interface ErrorEntity {
        data class NetworkError(val httpStatus: Int) : ErrorEntity
        object EmptyResponseError : ErrorEntity
        data class UnknownError(val exception: Exception) : ErrorEntity
    }
}