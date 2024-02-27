package com.mauriciojimenez.pokedex.domain

import com.mauriciojimenez.pokedex.data.local.entities.PokemonDataEntity
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonData

fun PokemonData.toEntity()= PokemonDataEntity(
    id=0,
    name= name,
    url = url,
)