package com.hana897trx.pokeapp.utilities

open class StateResult<out T : Any?> {
    data class Success<out T : Any?>(val data : T) : StateResult<T>()
    data class Loading(val loading : Boolean) : StateResult<Nothing>()
    data class Error(val errorCode : Int) : StateResult<Nothing>()
}