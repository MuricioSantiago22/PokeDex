package com.mauriciojimenez.pokedex.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mauriciojimenez.pokedex.domain.entity.action.Either
import com.mauriciojimenez.pokedex.domain.entity.dataEntity.PokemonName
import com.mauriciojimenez.pokedex.domain.entity.dataEntity.PokemonSprite
import com.mauriciojimenez.pokedex.domain.useCase.GetPokemonSpriteUseCase
import com.mauriciojimenez.pokedex.domain.useCase.GetPokemonNameUseCase
import com.mauriciojimenez.pokedex.domain.useCase.GetPokemonSpeciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class PokemonDataListViewModel @Inject constructor(
    private val getPokemonNameUseCase: GetPokemonNameUseCase,
    private val getPokemonSpriteUseCase: GetPokemonSpriteUseCase,
    private val getPokemonSpeciesUseCase: GetPokemonSpeciesUseCase,
    private val coroutineContext: CoroutineContext
): ViewModel() {

     private val _pokemonNameList : MutableLiveData<List<PokemonName>> =MutableLiveData()
     val pokemonNameList: LiveData<List<PokemonName>> get()= _pokemonNameList

    private val _pokemonDataSprite:MutableLiveData<List<PokemonSprite>> = MutableLiveData()
     val pokemonDataSprite: LiveData<List<PokemonSprite>> get()= _pokemonDataSprite
    init {
        getPokemon()
    }
    private fun getPokemon() {
        viewModelScope.launch(coroutineContext){
            val result = getPokemonNameUseCase()
            withContext(Dispatchers.Main) {
                when (result) {
                    is Either.Success -> {
                        getPokemonSprite(result.getData())
                        _pokemonNameList.value = result.getData()
                    }
                    is Either.Error -> {
                        result.error
                    }
                }
            }
        }
    }

    private fun getPokemonSprite(url:String){
        viewModelScope.launch(coroutineContext){
            val result = getPokemonSpriteUseCase(url)
            withContext(Dispatchers.Main){
                when(result){
                    is Either.Error -> {
                        result.error
                    }
                    is Either.Success -> {
                        _pokemonDataSprite.value = result.getData()
                    }
                }


            }

        }
    }

    private fun getPokemonSpecies(name:String){
        viewModelScope.launch (coroutineContext){
            val result = getPokemonSpeciesUseCase(name)
            withContext(Dispatchers.Main){
                when(result){
                    is Either.Success -> {}
                    is Either.Error -> {}

                }
            }
        }
    }
}