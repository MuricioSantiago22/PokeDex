package com.mauriciojimenez.pokedex.data.remote.entities.dto

import com.google.gson.annotations.SerializedName

data class SpritesDto (
    @SerializedName("sprites")
    var sprites: FrontSpritesDto
)