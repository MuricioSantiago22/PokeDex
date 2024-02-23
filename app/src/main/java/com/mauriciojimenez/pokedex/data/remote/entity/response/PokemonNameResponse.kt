package com.mauriciojimenez.pokedex.data.remote.entity.response

import com.google.gson.annotations.SerializedName
import com.mauriciojimenez.pokedex.data.remote.entity.dto.PokemonNameDto

data class PokemonNameResponse(
    @SerializedName("results")
    val results : List<PokemonNameDto> = listOf()
)
