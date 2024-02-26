package com.mauriciojimenez.pokedex.data.local.mappers


import com.mauriciojimenez.pokedex.data.local.entities.PokemonDataEntity
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonData

fun PokemonDataEntity.toDomain()=PokemonData(
    name = name,
    url = url

)

