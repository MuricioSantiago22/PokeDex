package com.mauriciojimenez.pokedex.domain.entity.dataEntity

import com.mauriciojimenez.pokedex.data.local.entity.PokemonNameEntity
import com.mauriciojimenez.pokedex.data.remote.entity.dto.PokemonNameDto


data class PokemonName(
    val name : String? = null,
    val url : String? = null
)

fun PokemonNameEntity.toDomain()=PokemonName(name)

fun PokemonNameDto.toDomain()=PokemonName(name, url)
