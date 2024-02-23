package com.mauriciojimenez.pokedex.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonNameDao {
    @Query("SELECT *  FROM pokemon_name_table")
    suspend fun getAllPokemonName():List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPokemonName(pokemonName:List<String>)

    @Query("DELETE FROM pokemon_name_table")
    suspend fun deleteAllPokemonName()
}