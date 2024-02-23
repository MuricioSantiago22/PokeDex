package com.mauriciojimenez.pokedex.domain.repository

import com.mauriciojimenez.pokedex.domain.entity.action.Either

interface PokemonSpritesRepository {
    fun getPokemonSprite(url:String): Either

}