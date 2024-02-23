package com.mauriciojimenez.pokedex.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mauriciojimenez.pokedex.data.local.entity.PokemonNameEntity

@Dao
interface PokemonNameDao {
    @Query("SELECT *  FROM pokemon_name_table ORDER BY id DESC")
    suspend fun getAllPokemonName():List<PokemonNameEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPokemonName(name:List<String>)

    @Query("DELETE FROM pokemon_name_table")
    suspend fun deleteAllPokemonName()
}