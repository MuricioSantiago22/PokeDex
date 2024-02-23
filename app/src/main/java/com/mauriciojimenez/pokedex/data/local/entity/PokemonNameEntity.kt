package com.mauriciojimenez.pokedex.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mauriciojimenez.pokedex.domain.entity.dataEntity.PokemonName

@Entity(tableName = "pokemon_name_table")
data class PokemonNameEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") val id : Int = 0,
    @ColumnInfo(name="name") val name : String? = null
)

fun PokemonName.toDataBase() =PokemonNameEntity(name = name)
