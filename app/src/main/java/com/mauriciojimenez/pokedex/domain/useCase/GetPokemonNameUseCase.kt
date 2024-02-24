package com.mauriciojimenez.pokedex.domain.useCase
import com.mauriciojimenez.pokedex.data.local.repository.PokemonDataDaoImpl
import com.mauriciojimenez.pokedex.domain.entities.action.Either
import com.mauriciojimenez.pokedex.domain.entities.action.error.ErrorStatus
import com.mauriciojimenez.pokedex.domain.repository.PokemonDataRepository
import javax.inject.Inject

class GetPokemonNameUseCase
@Inject constructor(
    private val pokemonDataDaoImpl: PokemonDataDaoImpl,
    private val pokemonDataRepository: PokemonDataRepository
) {
    operator fun invoke(): Either {
        if (pokemonDataDaoImpl.getAllPokemonData().equals(null)) {
            pokemonDataRepository.getPokemonName()
            try {
                pokemonDataDaoImpl.getAllPokemonData()
            } catch (e: Exception) {
                return Either.Error(ErrorStatus.UnknownError(e))
            }
        }

        return try {
            val pokemonData = pokemonDataDaoImpl.getAllPokemonData()
            Either.Success(pokemonData)
        } catch (e: Exception) {
            Either.Error(ErrorStatus.UnknownError(e))
        }
    }
}
