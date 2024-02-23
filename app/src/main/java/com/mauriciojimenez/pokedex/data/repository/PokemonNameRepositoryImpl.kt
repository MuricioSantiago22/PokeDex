package com.mauriciojimenez.pokedex.data.repository


import com.mauriciojimenez.pokedex.data.local.repository.PokemonNameDaoImpl
import com.mauriciojimenez.pokedex.data.remote.network.PokemonApiClient
import com.mauriciojimenez.pokedex.domain.entity.action.Either
import com.mauriciojimenez.pokedex.domain.entity.action.error.ErrorEntity
import com.mauriciojimenez.pokedex.domain.entity.dataEntity.toDomain
import com.mauriciojimenez.pokedex.domain.repository.PokemonNameRepository
import javax.inject.Inject

class PokemonNameRepositoryImpl
@Inject constructor(
    private val client: PokemonApiClient,
    private val pokemonNameDaoImpl: PokemonNameDaoImpl
): PokemonNameRepository {
    override fun getPokemonName(): Either = try {
        val response = client.getPokemonName( 151,0).execute()
        if (response.isSuccessful){
            response.body()?.let {
                pokemonNameDaoImpl.deleteAllPokemonName()
                pokemonNameDaoImpl.insertAllPokemonName(  it.results.map { it.name ?: "" })
                Either.Success(it.results.map { it.toDomain()})
            } ?: Either.Error(ErrorEntity.EmptyResponseError)
        }else{
            pokemonNameDaoImpl.getAllPokemonName()
            Either.Error(ErrorEntity.NetworkError(response.code()))
        }
    } catch (e: Exception) {
            Either.Error(ErrorEntity.UnknownError(e))

    }

}