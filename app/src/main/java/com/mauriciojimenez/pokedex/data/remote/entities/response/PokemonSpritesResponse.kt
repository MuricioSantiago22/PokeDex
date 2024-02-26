package com.mauriciojimenez.pokedex.data.remote.entities.response


import com.google.gson.annotations.SerializedName
import com.mauriciojimenez.pokedex.data.remote.entities.dto.FrontSpritesDto


data class PokemonSpritesResponse(
    @SerializedName("sprites")
    val sprites: List<FrontSpritesDto>
)

