package com.mauriciojimenez.pokedex.data.repository

import com.mauriciojimenez.pokedex.data.remote.network.PokemonApiClient
import com.mauriciojimenez.pokedex.domain.entity.action.Either
import com.mauriciojimenez.pokedex.domain.entity.action.error.ErrorEntity
import com.mauriciojimenez.pokedex.domain.repository.PokemonSpeciesRepository
import javax.inject.Inject

class PokemonSpeciesRepositoryImpl
@Inject constructor(
    private val client: PokemonApiClient): PokemonSpeciesRepository {
    override fun getPokemonSpecie(name:String): Either = try {
        val response = client.getPokemonSpecies(name).execute()
        if (response.isSuccessful){
            response.body()?.let {
                Either.Success(response)
            } ?: Either.Error(ErrorEntity.EmptyResponseError)
        }else{
            Either.Error(ErrorEntity.NetworkError(response.code()))
        }
    } catch (e: Exception) {
        Either.Error(ErrorEntity.UnknownError(e))

    }

}