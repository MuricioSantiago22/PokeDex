package com.mauriciojimenez.pokedex.domain.useCase

import com.mauriciojimenez.pokedex.domain.entities.action.Either
import com.mauriciojimenez.pokedex.domain.repository.PokemonSpeciesRepository
import javax.inject.Inject

class GetPokemonSpeciesUseCase
@Inject constructor(private val pokemonSpeciesRepository: PokemonSpeciesRepository) {
    operator fun invoke(name:String): Either {
        return pokemonSpeciesRepository.getPokemonSpecies(name)
    }
}