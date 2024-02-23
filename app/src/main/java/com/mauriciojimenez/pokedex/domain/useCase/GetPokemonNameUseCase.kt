package com.mauriciojimenez.pokedex.domain.useCase
import com.mauriciojimenez.pokedex.data.local.repository.PokemonNameDaoImpl
import com.mauriciojimenez.pokedex.domain.entity.action.Either
import com.mauriciojimenez.pokedex.domain.entity.action.error.ErrorEntity
import com.mauriciojimenez.pokedex.domain.repository.PokemonNameRepository
import javax.inject.Inject

class GetPokemonNameUseCase
@Inject constructor(
    private val pokemonNameDaoImpl: PokemonNameDaoImpl,
    private val pokemonNameRepository: PokemonNameRepository
) {

    operator fun invoke(): Either {
        if (pokemonNameDaoImpl.getAllPokemonName().isEmpty()) {
            try {
                pokemonNameRepository.getPokemonName()
            } catch (e: Exception) {
                return Either.Error(ErrorEntity.UnknownError(e))
            }
        }
        return try {
            val pokemonName = pokemonNameDaoImpl.getAllPokemonName()
            Either.Success(pokemonName)
        } catch (e: Exception) {
            Either.Error(ErrorEntity.UnknownError(e))
        }
    }
}
