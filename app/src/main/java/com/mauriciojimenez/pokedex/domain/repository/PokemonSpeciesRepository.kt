package com.mauriciojimenez.pokedex.domain.repository

import com.mauriciojimenez.pokedex.domain.entity.action.Either

interface PokemonSpeciesRepository {
    fun getPokemonSpecie(name:String): Either
}