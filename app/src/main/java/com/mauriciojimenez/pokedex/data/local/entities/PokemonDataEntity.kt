package com.mauriciojimenez.pokedex.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "url_data_table")
data class PokemonUrlDataEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") var id : Int = 0 ,
    @ColumnInfo(name="url")var url: String
)
