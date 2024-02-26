package com.mauriciojimenez.pokedex.data.local.repository

import com.mauriciojimenez.pokedex.data.local.dao.PokemonDataDao
import com.mauriciojimenez.pokedex.data.local.entities.PokemonDataEntity
import javax.inject.Inject

class PokemonDataDaoImpl @Inject constructor(private val pokemonDataDao: PokemonDataDao) {


    suspend fun countFiles(): Int{
    return pokemonDataDao.countEmptyFiles()}

    suspend fun getListData():List<PokemonDataEntity>  {
        return  pokemonDataDao.getListData()
    }


    suspend fun insertListData(pokemonListData: List<PokemonDataEntity>) {
         pokemonDataDao.insertListData(pokemonListData)
    }

    suspend fun deleteListData() {
        pokemonDataDao.deleteListData()
    }

    suspend fun updateImage(image:MutableList<PokemonDataEntity>){
        pokemonDataDao.updateImage(image)
    }

    /*private inline fun <T> runSuspend(crossinline block: suspend () -> T): T {
        return runBlocking {
            withContext(Dispatchers.IO) {
                block()
            }
        }
    }*/
}