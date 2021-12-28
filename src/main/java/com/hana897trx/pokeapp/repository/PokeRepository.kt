package com.hana897trx.pokeapp.repository

import com.hana897trx.pokeapp.model.PokeResponse
import com.hana897trx.pokeapp.utilities.StateResult

interface PokeRepository {
    suspend fun getPokemon() : StateResult<PokeResponse>
}