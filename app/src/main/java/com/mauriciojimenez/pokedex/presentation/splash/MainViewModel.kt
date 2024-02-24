package com.mauriciojimenez.pokedex.presentation.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mauriciojimenez.pokedex.domain.entities.action.Either
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonName
import com.mauriciojimenez.pokedex.domain.useCase.GetPokemonNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class PokemonDataListViewModel @Inject constructor(
    private val getPokemonNameUseCase: GetPokemonNameUseCase,
    private val coroutineContext: CoroutineContext
): ViewModel() {
     private val _pokemonNameNameList : MutableLiveData<List<PokemonName>> =MutableLiveData()

    init {
        getPokemon()
    }
    private fun getPokemon() {
        viewModelScope.launch(coroutineContext){
            val result = getPokemonNameUseCase()
            withContext(Dispatchers.Main) {
            when(result){

                is Either.Error -> {
                    result.error
                }
                is Either.Success -> {
                    _pokemonNameNameList.value = result.getData()
                }
            }}
        }
    }

}