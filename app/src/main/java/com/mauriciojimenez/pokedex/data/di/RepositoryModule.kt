package com.mauriciojimenez.pokedex.data.di

import com.mauriciojimenez.pokedex.data.repository.PokemonNameRepositoryImpl
import com.mauriciojimenez.pokedex.data.repository.PokemonSpritesRepositoryImpl
import com.mauriciojimenez.pokedex.domain.repository.PokemonNameRepository
import com.mauriciojimenez.pokedex.domain.repository.PokemonSpritesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providePokemonNameRepository(
        pokemonNameRepositoryImpl: PokemonNameRepositoryImpl
    ):PokemonNameRepository

    @Binds
    abstract fun providePokemonSpritesRepository(
        pokemonSpritesRepositoryImpl: PokemonSpritesRepositoryImpl
    ): PokemonSpritesRepository
}