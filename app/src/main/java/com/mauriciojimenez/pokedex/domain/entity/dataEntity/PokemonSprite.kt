package com.mauriciojimenez.pokedex.domain.entity.dataEntity

import com.mauriciojimenez.pokedex.data.local.entity.PokemonSpritesEntity
import com.mauriciojimenez.pokedex.data.remote.entity.dto.PokemonSpriteDto

data class PokemonSprite(
    val frontDefault: String? = null
)

fun PokemonSpriteDto.toDomain()= PokemonSprite(frontDefault)

fun PokemonSpritesEntity.toDomain()= PokemonSprite(frontDefault)
