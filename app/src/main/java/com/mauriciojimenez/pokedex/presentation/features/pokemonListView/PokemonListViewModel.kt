package com.mauriciojimenez.pokedex.presentation.features.pokemonListView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonData
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonSprites
import com.mauriciojimenez.pokedex.domain.useCase.GetPokemonDataUseCase
import com.mauriciojimenez.pokedex.domain.useCase.GetPokemonSpritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonDataUseCase: GetPokemonDataUseCase,
    private val getPokemonSpritesUseCase: GetPokemonSpritesUseCase,
    private val coroutineContext: CoroutineContext
):ViewModel() {

    private val _pokemonNameDataList : MutableLiveData<List<PokemonData>> = MutableLiveData()
    val pokemonNameList: LiveData<List<PokemonData>> get() = _pokemonNameDataList
    private val _pokemonSprites: MutableLiveData<List<PokemonSprites>> = MutableLiveData()


    init {
        getPokemonName()
    }


    private fun getPokemonName(){
        viewModelScope.launch(coroutineContext) {
           val response = getPokemonDataUseCase()
            withContext(Dispatchers.Main) {
            if(response.isNotEmpty()){
              _pokemonNameDataList.value = response }
            }
        }
    }
    fun getSpritePokemon(){
        viewModelScope.launch(coroutineContext){

        }
    }
}