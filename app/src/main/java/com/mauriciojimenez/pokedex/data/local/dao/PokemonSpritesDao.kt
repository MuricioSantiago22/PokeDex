package com.mauriciojimenez.pokedex.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface PokemonSpritesDao {

@Query("SELECT *  FROM sprites_table ORDER BY id DESC")
suspend fun getAllPokemonSprites():List<String>

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertAllPokemonSprites(sprites: List<String>)

@Query("DELETE FROM sprites_table")
suspend fun deleteAllPokemonSprites()
}