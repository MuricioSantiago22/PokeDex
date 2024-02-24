package com.mauriciojimenez.pokedex.data.remote.network

import com.mauriciojimenez.pokedex.data.remote.entities.response.PokemonDataResponse
import com.mauriciojimenez.pokedex.data.remote.entities.response.PokemonSpeciesResponse
import com.mauriciojimenez.pokedex.data.remote.entities.response.PokemonSpritesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface PokemonApiClient {
    @GET
    fun getPokemonSprite(@Url url: String
    ): Call<PokemonSpritesResponse>
    @GET("pokemon")
    fun getPokemonData(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Call<PokemonDataResponse>

    @GET("pokemon-species/{name}")
    fun getPokemonSpecies(
        @Path("name")name: String
    ):Call<PokemonSpeciesResponse>
}