package com.hana897trx.pokeapp.repository

import com.hana897trx.pokeapp.PokeService
import com.hana897trx.pokeapp.model.PokeResponse
import com.hana897trx.pokeapp.utilities.StateResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class PokeRepositoryImp : PokeRepository {

    private val service = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokeService::class.java)

    override suspend fun getPokemon(): StateResult<PokeResponse> {
        val response = service.getPockemon().await()

        return if(response != null)
            StateResult.Success(response)
        else
            StateResult.Error(404)
    }
}