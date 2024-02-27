package com.mauriciojimenez.pokedex.data.remote.mapper

import com.mauriciojimenez.pokedex.data.local.entities.PokemonDataEntity
import com.mauriciojimenez.pokedex.data.remote.entities.dto.PokemonDataDto
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonData

fun PokemonDataDto.toDomain()=PokemonData(
        name = this.name,
        url= this.url
    )


fun PokemonDataDto.toEntity(id: Int)= PokemonDataEntity(
    id= id,
    name = this.name,
    url = this.url
)


