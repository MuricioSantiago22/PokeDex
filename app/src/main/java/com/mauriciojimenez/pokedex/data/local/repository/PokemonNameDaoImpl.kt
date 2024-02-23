package com.mauriciojimenez.pokedex.data.local.repository

import com.mauriciojimenez.pokedex.data.local.dao.PokemonNameDao
import com.mauriciojimenez.pokedex.domain.entity.dataEntity.PokemonName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonNameDaoImpl @Inject constructor(private val pokemonNameDao: PokemonNameDao)  {

    fun getAllPokemonName(): List<String>{
        return runSuspend { pokemonNameDao.getAllPokemonName() }
    }

    fun insertAllPokemonName( pokemonName:List<String>) {
        runSuspend { pokemonNameDao.insertAllPokemonName(pokemonName) }
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