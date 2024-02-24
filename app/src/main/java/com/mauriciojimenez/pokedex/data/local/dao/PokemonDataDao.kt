package com.mauriciojimenez.pokedex.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mauriciojimenez.pokedex.data.local.entities.PokemonDataEntity

@Dao
interface PokemonDataDao {
    @Query("SELECT *  FROM pokemon_table")
    suspend fun getAllUrlData(): PokemonDataEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUrlData(pokemonUrlDataEntity:PokemonDataEntity)

    @Query("DELETE FROM pokemon_table")
    suspend fun deleteAllUrlData()
}