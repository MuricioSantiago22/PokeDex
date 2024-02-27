package com.mauriciojimenez.pokedex.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mauriciojimenez.pokedex.data.local.entities.PokemonDataEntity

@Dao
interface PokemonDataDao {


    @Query("SELECT COUNT(*) FROM pokemon_table WHERE name ")
    suspend fun countEmptyFiles(): Int
    @Query("SELECT *  FROM pokemon_table ORDER BY id")
    suspend fun getListData(): List<PokemonDataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListData(list:List<PokemonDataEntity>)

    @Query("DELETE FROM pokemon_table")
    suspend fun deleteListData()

    @Update
    suspend fun updateImage(image:MutableList<PokemonDataEntity>)
}