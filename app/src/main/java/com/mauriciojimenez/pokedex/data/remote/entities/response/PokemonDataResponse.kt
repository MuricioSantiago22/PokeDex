package com.mauriciojimenez.pokedex.data.remote.entities.response

import com.google.gson.annotations.SerializedName
import com.mauriciojimenez.pokedex.data.remote.entities.dto.PokemonDataDto

data class PokemonDataResponse(
    @SerializedName("results")
    var results:List<PokemonDataDto>

)
