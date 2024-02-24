package com.mauriciojimenez.pokedex.domain.entities.data

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("name")
    var namePk: String
)
