package com.mauriciojimenez.pokedex.domain.useCase

import com.mauriciojimenez.pokedex.data.local.repository.PokemonSpriteDaoImpl
import com.mauriciojimenez.pokedex.domain.entity.action.Either
import com.mauriciojimenez.pokedex.domain.entity.action.error.ErrorEntity
import com.mauriciojimenez.pokedex.domain.repository.PokemonSpritesRepository
import javax.inject.Inject

class GetPokemonSpriteUseCase
@Inject constructor(
    private val pokemonSpritesRepository: PokemonSpritesRepository,
    private val pokemonSpriteDaoImpl: PokemonSpriteDaoImpl
) {

    operator fun invoke(url: String): Either {
        if (pokemonSpriteDaoImpl.getAllPokemonSprite().isEmpty()) {
            try {
                pokemonSpritesRepository.getPokemonSprite(url)
            } catch (e: Exception) {
                return Either.Error(ErrorEntity.UnknownError(e))
            }
        }

        return try {
            val pokemonName = pokemonSpriteDaoImpl.getAllPokemonSprite()
            Either.Success(pokemonName)
        } catch (e: Exception) {
            Either.Error(ErrorEntity.UnknownError(e))
        }
    }
}

