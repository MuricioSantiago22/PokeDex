package com.mauriciojimenez.pokedex.data.local.repository

import com.mauriciojimenez.pokedex.data.local.dao.PokemonDataDao
import com.mauriciojimenez.pokedex.data.local.entities.PokemonDataEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonUrlDataDaoImpl @Inject constructor(private val pokemonSpriteDao: PokemonDataDao) {
    fun getAllUrlData(): PokemonDataEntity {
        return runSuspend { pokemonSpriteDao.getAllUrlData() }
    }

    fun insertAllData(pokemonSprite: PokemonDataEntity) {
        runSuspend { pokemonSpriteDao.insertAllUrlData(pokemonSprite) }
    }

    fun deleteAllData() {
        runSuspend { pokemonSpriteDao.deleteAllUrlData() }
    }

    private inline fun <T> runSuspend(crossinline block: suspend () -> T): T {
        return runBlocking {
            withContext(Dispatchers.IO) {
                block()
            }
        }
    }
}