package com.mauriciojimenez.pokedex.domain.repository

import com.mauriciojimenez.pokedex.domain.entities.data.PokemonSprites

interface PokemonSpritesRepository {
    suspend fun getPokemonSprites(id:Int):PokemonSprites
}