package com.mauriciojimenez.pokedex.data.remote.network

import com.mauriciojimenez.pokedex.data.remote.entities.response.PokemonDataResponse
import com.mauriciojimenez.pokedex.data.remote.entities.response.PokemonSpeciesResponse
import com.mauriciojimenez.pokedex.data.remote.entities.response.PokemonSpritesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiClient {
    @GET("pokemon/{id}")
    suspend fun getPokemonSprite(
        @Path("id") id: Int
    ): Response<PokemonSpritesResponse>

    @GET("pokemon")
    suspend fun getPokemonData(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<PokemonDataResponse>

    @GET("pokemon-species/{name}")
    fun getPokemonSpecies(
        @Path("name")name: String
    ):Response<PokemonSpeciesResponse>
}