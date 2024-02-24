package com.mauriciojimenez.pokedex.data.repository


import com.mauriciojimenez.pokedex.data.local.repository.PokemonDataDaoImpl
import com.mauriciojimenez.pokedex.data.remote.mapper.toEntity
import com.mauriciojimenez.pokedex.data.remote.network.PokemonApiClient
import com.mauriciojimenez.pokedex.domain.entities.action.Either
import com.mauriciojimenez.pokedex.domain.entities.action.error.ErrorStatus
import com.mauriciojimenez.pokedex.domain.repository.PokemonDataRepository
import javax.inject.Inject

class PokemonDataRepositoryImpl
@Inject constructor(
    private val client: PokemonApiClient,
    private val pokemonDataDaoImpl: PokemonDataDaoImpl
): PokemonDataRepository {
    override fun getPokemonName(): Either = try {
        val response = client.getPokemonData( 151,0).execute()
        if (response.isSuccessful){
            response.body()?.let {body ->
                pokemonDataDaoImpl.deleteAllData()
                pokemonDataDaoImpl.insertAllPokemonData(body.pokemonData.toEntity())
                Either.Success(body.pokemonData)

            } ?: Either.Error(ErrorStatus.EmptyResponseError)
        }else{
            Either.Error(ErrorStatus.NetworkError(response.code()))
        }
    } catch (e: Exception) {
            Either.Error(ErrorStatus.UnknownError(e))

    }

}