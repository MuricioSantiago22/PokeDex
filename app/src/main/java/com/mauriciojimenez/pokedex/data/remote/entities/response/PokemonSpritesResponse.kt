package com.mauriciojimenez.pokedex.data.remote.entities.response


import com.google.gson.annotations.SerializedName
import com.mauriciojimenez.pokedex.data.remote.entities.dto.PokemonSpritesDto


data class PokemonSpritesResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("weight") val weight: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("sprites") val sprites: PokemonSpritesDto
)


