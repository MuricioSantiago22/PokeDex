package com.mauriciojimenez.pokedex.presentation.features.pokemonSplashView

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mauriciojimenez.pokedex.domain.useCase.GetPokemonDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPokemonDataUseCase: GetPokemonDataUseCase,
    private val coroutineContext: CoroutineContext
): ViewModel() {
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
                        _pokemonSprites.value = result.getData()
                    }
                }


            }

        }
    }*/

}