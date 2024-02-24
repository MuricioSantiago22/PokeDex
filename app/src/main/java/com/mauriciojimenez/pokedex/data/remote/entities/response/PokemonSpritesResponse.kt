package com.mauriciojimenez.pokedex.data.remote.entities.response


import com.google.gson.annotations.SerializedName
import com.mauriciojimenez.pokedex.data.remote.entities.dto.SpritesDto


data class PokemonSpritesResponse(
    @SerializedName("sprites")
    val sprites: SpritesDto
)

