package com.hana897trx.pokeapp.utilities

import com.hana897trx.pokeapp.model.PokeResponse

sealed class PokeDataUI {
    data class Success(val data : PokeResponse) : PokeDataUI()
    object Error : PokeDataUI()
    data class Loading(val loading : Boolean) : PokeDataUI()
}