package com.mauriciojimenez.pokedex.data.remote.mapper

import com.mauriciojimenez.pokedex.data.local.entities.PokemonDataEntity
import com.mauriciojimenez.pokedex.data.remote.entities.dto.PokemonDataDto

fun PokemonDataDto.toEntity(): PokemonDataEntity{
    return PokemonDataEntity(
        name = this.name,
        url= this.url
    )
}