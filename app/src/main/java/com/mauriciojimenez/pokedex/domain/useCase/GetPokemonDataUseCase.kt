package com.mauriciojimenez.pokedex.domain.useCase
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonData
import com.mauriciojimenez.pokedex.domain.repository.PokemonDataRepository
import com.mauriciojimenez.pokedex.domain.toEntity
import javax.inject.Inject

class GetPokemonDataUseCase @Inject constructor(
    private val pokemonDataRepository: PokemonDataRepository
) {
    suspend operator fun invoke(): List<PokemonData>{
        val response = pokemonDataRepository.getPokemonDataFromApi()
        return if(response.isNotEmpty()){
            pokemonDataRepository.clearDataBase()
            pokemonDataRepository.insertPokemonData(response.map { it.toEntity()})
            response
        }else{
            pokemonDataRepository.getPokemonDataFromDB()
        }
    }

}
