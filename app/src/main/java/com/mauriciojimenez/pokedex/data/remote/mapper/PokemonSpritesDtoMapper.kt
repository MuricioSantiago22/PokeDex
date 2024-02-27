package com.mauriciojimenez.pokedex.data.remote.mapper

import com.mauriciojimenez.pokedex.data.remote.entities.dto.PokemonSpritesDto
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonSprites

fun PokemonSpritesDto.toDomain()= PokemonSprites(
    sprite = frontSprites
)