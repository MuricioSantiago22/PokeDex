package com.mauriciojimenez.pokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mauriciojimenez.pokedex.data.local.dao.PokemonNameDao
import com.mauriciojimenez.pokedex.data.local.dao.PokemonSpritesDao
import com.mauriciojimenez.pokedex.data.local.entity.PokemonNameEntity
import com.mauriciojimenez.pokedex.data.local.entity.PokemonSpritesEntity

@Database(entities = [PokemonNameEntity::class, PokemonSpritesEntity::class], version = 1)
abstract class PokemonDataBase:RoomDatabase(){
    abstract fun getPokemonNameDao():PokemonNameDao
    abstract fun getPokemonSpritesDao():PokemonSpritesDao
}