package com.mauriciojimenez.pokedex.data.remote.entity.dto

import com.google.gson.annotations.SerializedName

data class PokemonSpriteDto(
    @SerializedName("front_default")
    val frontDefault: String? = null
)