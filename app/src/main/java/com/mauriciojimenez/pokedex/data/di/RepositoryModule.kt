package com.mauriciojimenez.pokedex.data.di

import com.mauriciojimenez.pokedex.data.repository.PokemonDataRepositoryImpl
import com.mauriciojimenez.pokedex.domain.repository.PokemonDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun pokemonDataRepository(
        mealsCategoryRepositoryImpl: PokemonDataRepositoryImpl
    ): PokemonDataRepository
}