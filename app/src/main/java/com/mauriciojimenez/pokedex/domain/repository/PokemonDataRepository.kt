package com.mauriciojimenez.pokedex.domain.repository


import com.mauriciojimenez.pokedex.data.local.entities.PokemonDataEntity
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonData

interface PokemonDataRepository {
    suspend fun getPokemonDataFromApi():List<PokemonData>

    suspend fun getPokemonDataFromDB():List<PokemonData>

    suspend fun  insertPokemonData(list:List<PokemonDataEntity>)
    suspend fun  clearDataBase()

}