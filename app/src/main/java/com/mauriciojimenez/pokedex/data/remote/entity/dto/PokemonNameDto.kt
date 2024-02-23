package com.mauriciojimenez.pokedex.data.remote.entity.dto

import com.google.gson.annotations.SerializedName

data class PokemonNameDto(
    @SerializedName("name")
    val name : String? = null,
    @SerializedName("url")
    val url : String? = null
)
