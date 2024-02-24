package com.mauriciojimenez.pokedex.domain.entities.action

import com.mauriciojimenez.pokedex.domain.entities.action.error.ErrorStatus

sealed interface Either {
    data class Success (private val data: Any) : Either {
        @Suppress("UNCHECKED_CAST")
        fun <R> getData() = data as R//Developer error let it throw exception...
    }
    data class Error(val error: ErrorStatus): Either
}