package com.mauriciojimenez.pokedex.domain.repository

import com.mauriciojimenez.pokedex.domain.entities.action.Either

interface PokemonDataRepository {
    fun getPokemonName(): Either
}