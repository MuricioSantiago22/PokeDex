package com.mauriciojimenez.pokedex.domain.entities.data

import com.google.gson.annotations.SerializedName

data class SpritePk(
    @SerializedName("front_default")
    var frontImage:String
)
