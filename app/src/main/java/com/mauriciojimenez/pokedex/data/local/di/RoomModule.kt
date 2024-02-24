package com.mauriciojimenez.pokedex.data.local.di

import android.content.Context
import androidx.room.Room
import com.mauriciojimenez.pokedex.data.local.PokemonDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val POKEMON_DATABASE_NAME = "pokemon_database"
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context)=
        Room.databaseBuilder(context, PokemonDataBase::class.java, POKEMON_DATABASE_NAME).build()



    @Singleton
    @Provides
    fun provideGetPokemonDataDao(db:PokemonDataBase)=db.getPokemonDataDao()

}