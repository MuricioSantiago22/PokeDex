package com.mauriciojimenez.pokedex.data.remote.network

import com.mauriciojimenez.pokedex.data.remote.entity.response.PokemonNameResponse
import com.mauriciojimenez.pokedex.data.remote.entity.response.PokemonSpritesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface PokemonApiClient {
    @GET
     fun getPokemonSprite(@Url url: String
    ): Call<PokemonSpritesResponse>
    @GET("pokemon")
     fun getPokemonName(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Call<PokemonNameResponse>
}