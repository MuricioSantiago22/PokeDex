package com.mauriciojimenez.pokedex.data.repository

import com.mauriciojimenez.pokedex.data.local.entities.PokemonDataEntity
import com.mauriciojimenez.pokedex.data.local.mappers.toDomain
import com.mauriciojimenez.pokedex.data.local.repository.PokemonDataDaoImpl
import com.mauriciojimenez.pokedex.data.remote.mapper.toDomain
import com.mauriciojimenez.pokedex.data.remote.network.PokemonApiClient
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonData
import com.mauriciojimenez.pokedex.domain.repository.PokemonDataRepository

import javax.inject.Inject

class PokemonDataRepositoryImpl
@Inject constructor(
    private val client: PokemonApiClient,
    private val pokemonDataDaoImpl: PokemonDataDaoImpl
): PokemonDataRepository {

    override suspend fun getPokemonDataFromApi():List<PokemonData>{
            val response  =  client.getPokemonData(151, 0)
            return response.body()?.results?.map { it.toDomain() }?: listOf()}

    override suspend fun getPokemonDataFromDB(): List<PokemonData> {
        val response:List<PokemonDataEntity> = pokemonDataDaoImpl.getListData()
        return  response.map { it.toDomain() }
    }

    override suspend fun insertPokemonData(list: List<PokemonDataEntity>) {
        pokemonDataDaoImpl.insertListData(list)
    }

    override suspend fun clearDataBase() {}
}











