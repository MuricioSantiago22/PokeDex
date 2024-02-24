package com.mauriciojimenez.pokedex.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mauriciojimenez.pokedex.data.local.entities.PokemonUrlDataEntity

@Dao
interface PokemonUrlDataDao {
    @Query("SELECT *  FROM pokemon_name_table")
    suspend fun getAllUrlData(): PokemonUrlDataEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUrlData(pokemonUrlDataEntity:PokemonUrlDataEntity)

    @Query("DELETE FROM pokemon_name_table")
    suspend fun deleteAllUrlData()
}