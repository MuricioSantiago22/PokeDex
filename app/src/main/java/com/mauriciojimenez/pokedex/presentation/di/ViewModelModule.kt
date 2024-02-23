package com.mauriciojimenez.pokedex.presentation.di

import com.mauriciojimenez.pokedex.domain.useCase.GetPokemonSpriteUseCase
import com.mauriciojimenez.pokedex.domain.useCase.GetPokemonNameUseCase
import com.mauriciojimenez.pokedex.presentation.di.CoroutineScopeModule.provideIOCoroutineContext
import com.mauriciojimenez.pokedex.presentation.splash.PokemonDataListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {

    @Provides
    fun provideDataListViewModel(
        getPokemonNameUseCase: GetPokemonNameUseCase,
        getPokemonSpriteUseCase: GetPokemonSpriteUseCase
    ): PokemonDataListViewModel {
        return PokemonDataListViewModel(getPokemonNameUseCase,getPokemonSpriteUseCase,  provideIOCoroutineContext())
    }
}