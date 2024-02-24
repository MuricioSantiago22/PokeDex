package com.mauriciojimenez.pokedex.domain.repository

import com.mauriciojimenez.pokedex.domain.entities.action.Either

interface PokemonSpritesRepository {
    fun getPokemonSprites(name:String): Either
}