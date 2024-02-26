package com.mauriciojimenez.pokedex.data.remote.entities.dto

import com.google.gson.annotations.SerializedName

data class PokemonDataDto (
    @SerializedName("name")
    var name:String,

    @SerializedName("url")
    var url: String,

    var image: String
)
