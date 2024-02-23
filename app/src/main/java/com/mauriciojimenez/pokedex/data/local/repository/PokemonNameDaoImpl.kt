package com.mauriciojimenez.pokedex.data.local.repository

import com.mauriciojimenez.pokedex.data.local.dao.PokemonNameDao
import com.mauriciojimenez.pokedex.data.local.entity.PokemonNameEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonNameDaoImpl @Inject constructor(private val pokemonNameDao: PokemonNameDao)  {

    fun getAllPokemonName(): List<PokemonNameEntity>{
        return runSuspend { pokemonNameDao.getAllPokemonName() }
    }

    fun insertAllPokemonName(names: List<String>) {
        runSuspend { pokemonNameDao.insertAllPokemonName(names) }
    }

    fun deleteAllPokemonName() {
        runSuspend { pokemonNameDao.deleteAllPokemonName() }
    }

    private inline fun <T> runSuspend(crossinline block: suspend () -> T): T {
        return runBlocking {
            withContext(Dispatchers.IO) {
                block()
            }
        }
    }
}