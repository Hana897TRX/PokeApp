package com.hana897trx.pokeapp

import androidx.lifecycle.ViewModel
import com.hana897trx.pokeapp.repository.PokeRepositoryImp
import com.hana897trx.pokeapp.utilities.PokeDataUI
import com.hana897trx.pokeapp.utilities.StateResult
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel : ViewModel() {
    private var pokeRepositoryImp : PokeRepositoryImp

    init {
        pokeRepositoryImp = PokeRepositoryImp()
    }

    private val pokeDataUiState : MutableStateFlow<PokeDataUI> = MutableStateFlow(PokeDataUI.Loading(false))
    val _pokeDataUiState = pokeDataUiState

    suspend fun getPokeData() {
        when(val response = pokeRepositoryImp.getPokemon()) {
            is StateResult.Success -> pokeDataUiState.emit(PokeDataUI.Success(response.data))
            is StateResult.Error -> { }
            is StateResult.Loading -> pokeDataUiState.emit(PokeDataUI.Loading(true))
        }
    }
}