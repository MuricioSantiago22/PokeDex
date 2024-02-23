package com.mauriciojimenez.pokedex.data.repository

import com.mauriciojimenez.pokedex.data.local.dao.PokemonSpritesDao
import com.mauriciojimenez.pokedex.data.remote.network.PokemonApiClient
import com.mauriciojimenez.pokedex.domain.entity.action.Either
import com.mauriciojimenez.pokedex.domain.entity.action.error.ErrorEntity
import com.mauriciojimenez.pokedex.domain.entity.dataEntity.toDomain
import com.mauriciojimenez.pokedex.domain.repository.PokemonSpritesRepository
import javax.inject.Inject

class PokemonSpritesRepositoryImpl@Inject constructor(
    private val client: PokemonApiClient,
    private val pokemonSpritesDao: PokemonSpritesDao
): PokemonSpritesRepository {
    override fun getPokemonSprite(url:String): Either = try{
        val response = client.getPokemonSprite(url).execute()
        if (response.isSuccessful) {
            response.body()?.let { body ->
                Either.Success(body.sprites?.toDomain()?:"")
            }?: Either.Error(ErrorEntity.EmptyResponseError)
        }else{
            Either.Error(ErrorEntity.NetworkError(response.code()))
        }
    }catch (e: Exception) {
        Either.Error(ErrorEntity.UnknownError(e))
    }

}