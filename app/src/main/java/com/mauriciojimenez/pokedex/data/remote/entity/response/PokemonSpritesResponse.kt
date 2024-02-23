package com.mauriciojimenez.pokedex.data.remote.entity.response

import com.google.gson.annotations.SerializedName
import com.mauriciojimenez.pokedex.data.remote.entity.dto.PokemonSpriteDto

data class PokemonSpritesResponse(
    @SerializedName("sprites")
    val sprites: List<PokemonSpriteDto> = listOf()
)
