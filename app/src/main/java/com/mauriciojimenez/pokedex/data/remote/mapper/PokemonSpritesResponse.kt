package com.mauriciojimenez.pokedex.data.remote.mapper

import com.mauriciojimenez.pokedex.data.local.entities.PokemonDataEntity
import com.mauriciojimenez.pokedex.data.remote.entities.dto.FrontSpritesDto

fun FrontSpritesDto.toEntity(id: Int) = PokemonDataEntity(
    id = id,
    name= "",
    url= "",
    image = frontSprites
)