package com.mauriciojimenez.pokedex.presentation.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonData
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonUrlSprite
import com.mauriciojimenez.pokedex.domain.useCase.GetPokemonDataUseCase
import com.mauriciojimenez.pokedex.domain.useCase.GetPokemonSpritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPokemonDataUseCase: GetPokemonDataUseCase,
    private val coroutineContext: CoroutineContext
): ViewModel() {
     private val _pokemonNameDataList : MutableLiveData<List<PokemonData>> =MutableLiveData()

    private val _pokemonUrlSprite: MutableLiveData<List<PokemonUrlSprite>> = MutableLiveData()
     fun getPokemon() {
        viewModelScope.launch(coroutineContext) {
          getPokemonDataUseCase()
        }
     }



            //var url =_pokemonNameDataList.value?.get(1).let { it?.url}
                    //getPokemonSprites(url?:"")


   /* private fun getPokemonSprites(url:String){
        viewModelScope.launch(coroutineContext){
            val result = getPokemonSpritesUseCase(url)
            withContext(Dispatchers.Main){
                when(result){
                    is Either.Error -> {
                        result.error
                    }
                    is Either.Success -> {
                        _pokemonUrlSprite.value = result.getData()
                    }
                }


            }

        }
    }*/

}