package com.mauriciojimenez.pokedex.presentation.di

import com.mauriciojimenez.pokedex.domain.useCase.GetPokemonDataUseCase
import com.mauriciojimenez.pokedex.domain.useCase.GetPokemonSpritesUseCase
import com.mauriciojimenez.pokedex.presentation.di.CoroutineScopeModule.provideIOCoroutineContext
import com.mauriciojimenez.pokedex.presentation.splash.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {
    @Provides
    fun providePokemonDataListViewModel(
        getPokemonDataUseCase: GetPokemonDataUseCase,

    ): MainViewModel{
        return MainViewModel(getPokemonDataUseCase,  provideIOCoroutineContext())
    }

}