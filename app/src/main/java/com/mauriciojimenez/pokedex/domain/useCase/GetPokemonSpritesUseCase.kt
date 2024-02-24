package com.mauriciojimenez.pokedex.domain.useCase

import com.mauriciojimenez.pokedex.data.local.repository.PokemonSpriteDaoImpl
import com.mauriciojimenez.pokedex.domain.entities.action.Either
import com.mauriciojimenez.pokedex.domain.entities.action.error.ErrorStatus
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
                return Either.Error(ErrorStatus.UnknownError(e))
            }
        }

        return try {
            val pokemonSprite = pokemonSpriteDaoImpl.getAllPokemonSprite()
            Either.Success(pokemonSprite)
        } catch (e: Exception) {
            Either.Error(ErrorStatus.UnknownError(e))
        }
    }
}

