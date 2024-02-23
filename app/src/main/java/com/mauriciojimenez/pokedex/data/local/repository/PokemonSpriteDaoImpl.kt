package com.mauriciojimenez.pokedex.data.local.repository

import com.mauriciojimenez.pokedex.data.local.dao.PokemonSpritesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonSpriteDaoImpl @Inject constructor(private val pokemonSpriteDao: PokemonSpritesDao) {
    fun getAllPokemonSprite(): List<String>{
        return runSuspend { pokemonSpriteDao.getAllPokemonSprites() }
    }

    fun insertAllPokemonName(url: List<String>) {
        runSuspend { pokemonSpriteDao.insertAllPokemonSprites(url) }
    }

    fun deleteAllPokemonName() {
        runSuspend { pokemonSpriteDao.deleteAllPokemonSprites() }
    }

    private inline fun <T> runSuspend(crossinline block: suspend () -> T): T {
        return runBlocking {
            withContext(Dispatchers.IO) {
                block()
            }
        }
    }
}