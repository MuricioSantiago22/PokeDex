package com.mauriciojimenez.pokedex.data.remote.entities.dto

import com.google.gson.annotations.SerializedName

data class PokemonSpritesDto(
    @SerializedName("front_default")
    var frontSprites: String
)
