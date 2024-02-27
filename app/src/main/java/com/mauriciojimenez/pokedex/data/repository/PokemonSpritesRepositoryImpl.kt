package com.mauriciojimenez.pokedex.data.repository

import com.mauriciojimenez.pokedex.data.local.repository.PokemonDataDaoImpl
import com.mauriciojimenez.pokedex.data.remote.mapper.toDomain
import com.mauriciojimenez.pokedex.data.remote.network.PokemonApiClient
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonSprites
import com.mauriciojimenez.pokedex.domain.repository.PokemonSpritesRepository
import javax.inject.Inject

class PokemonSpritesRepositoryImpl @Inject constructor(
    private val client: PokemonApiClient,
    private val pokemonDataDaoImpl: PokemonDataDaoImpl
): PokemonSpritesRepository {
    /*override fun getPokemonSprite(url:String): Either = try{
        val response = client.getPokemonSprite(url).execute()
        if (response.isSuccessful) {

            response.body()?.let {
                pokemonDataDaoImpl.deleteAllUrlData()
                pokemonDataDaoImpl.insertAllUrlData()
                Either.Success(it.sprites.map{})
            }?: Either.Error(ErrorStatus.EmptyResponseError)
        }else{
            Either.Error(ErrorStatus.NetworkError(response.code()))
        }
    }catch (e: Exception) {
        Either.Error(ErrorStatus.UnknownError(e))
    }*/

    override suspend fun getPokemonSprites(id: Int):PokemonSprites{
        val response = client.getPokemonSprite(id)
        return response.body().let{it?.sprites?.toDomain()!!}
    }
}