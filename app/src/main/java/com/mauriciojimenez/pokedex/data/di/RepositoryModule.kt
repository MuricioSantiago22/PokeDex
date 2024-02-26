package com.mauriciojimenez.pokedex.data.di

import com.mauriciojimenez.pokedex.data.repository.PokemonDataRepositoryImpl
import com.mauriciojimenez.pokedex.data.repository.PokemonSpritesRepositoryImpl
import com.mauriciojimenez.pokedex.domain.repository.PokemonDataRepository
import com.mauriciojimenez.pokedex.domain.repository.PokemonSpritesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun pokemonDataRepository(
        pokemonDataRepositoryImpl: PokemonDataRepositoryImpl
    ): PokemonDataRepository

    @Binds
    abstract fun pokemonSpritesRepository(
        pokemonSpritesRepositoryImpl: PokemonSpritesRepositoryImpl

    ):PokemonSpritesRepository
}