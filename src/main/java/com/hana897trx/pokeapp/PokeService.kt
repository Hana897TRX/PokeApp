package com.hana897trx.pokeapp

import com.hana897trx.pokeapp.model.PokeResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeService {
    @GET("pokemon/")
    fun getPockemon() : Call<PokeResponse>
}