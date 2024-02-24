package com.mauriciojimenez.pokedex.data.local
import androidx.room.Database
import androidx.room.RoomDatabase
import com.mauriciojimenez.pokedex.data.local.dao.PokemonDataDao
import com.mauriciojimenez.pokedex.data.local.entities.PokemonDataEntity

@Database(entities = [PokemonDataEntity::class], version = 1)
abstract class PokemonDataBase:RoomDatabase() {
    abstract fun getPokemonDataDao(): PokemonDataDao
}