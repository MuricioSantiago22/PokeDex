package com.mauriciojimenez.pokedex.data.remote.entities.response

import com.google.gson.annotations.SerializedName

data class PokemonSpeciesResponse(
    @SerializedName("name")
    var name :String? = null,
    @SerializedName("base_happiness")
    var baseHappiness: Int = 0,
    @SerializedName("capture_rate")
    var captureRate:Int =0,
    @SerializedName("egg_groups")
    var ehhGroups :List<nameEggs?> = listOf()


)
data class nameEggs(
    var egg: String? = null
)
