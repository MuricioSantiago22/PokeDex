package com.mauriciojimenez.pokedex.domain.useCase

import com.mauriciojimenez.pokedex.domain.repository.PokemonSpritesRepository
import javax.inject.Inject

class GetPokemonSpritesUseCase
@Inject constructor(
    private val pokemonSpritesRepository: PokemonSpritesRepository
) {
   suspend operator fun invoke(id:Int){
       pokemonSpritesRepository.getPokemonSprites(id)
   }
}
   /* operator fun invoke(url: String): Either {
        if (pokemonDataDaoImpl.getAllUrlData().isEmpty()) {
            try {
                pokemonSpritesRepository.getPokemonSprites(url)
            } catch (e: Exception) {
                return Either.Error(ErrorStatus.UnknownError(e))
            }
        }

        return try {
            val pokemonSprite = pokemonDataDaoImpl.getAllUrlData()
            Either.Success(pokemonSprite)
        } catch (e: Exception) {
            Either.Error(ErrorStatus.UnknownError(e))
        }
    }*/

