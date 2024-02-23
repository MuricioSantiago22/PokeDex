package com.mauriciojimenez.pokedex.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mauriciojimenez.pokedex.domain.entity.dataEntity.PokemonSprite

@Entity(tableName = "sprites_table")
data class PokemonSpritesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") val id : Int = 0,
    @ColumnInfo(name="sprite")val frontDefault: String? = null
)
fun PokemonSprite.toDataBase() =PokemonSpritesEntity(frontDefault=frontDefault)
