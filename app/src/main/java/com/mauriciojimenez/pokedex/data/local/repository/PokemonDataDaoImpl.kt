package com.mauriciojimenez.pokedex.data.local.repository

import com.mauriciojimenez.pokedex.data.local.dao.PokemonDataDao
import com.mauriciojimenez.pokedex.data.local.entities.PokemonDataEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonDataDaoImpl @Inject constructor(private val pokemonSpriteDao: PokemonDataDao) {
    fun getAllPokemonData(): PokemonDataEntity {
        return runSuspend { pokemonSpriteDao.getAllUrlData() }
    }

    fun insertAllPokemonData(pokemonData: PokemonDataEntity) {
        runSuspend { pokemonSpriteDao.insertAllUrlData(pokemonData) }
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