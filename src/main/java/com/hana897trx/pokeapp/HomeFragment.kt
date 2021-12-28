package com.hana897trx.pokeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hana897trx.pokeapp.databinding.FragmentHomeBinding
import com.hana897trx.pokeapp.model.PokeResponse
import com.hana897trx.pokeapp.utilities.PokeAdapter
import com.hana897trx.pokeapp.utilities.PokeDataUI
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel : HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        lifecycleScope.launch {
            viewModel.getPokeData()
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                setObservable()
            }
        }
    }

    private suspend fun setObservable() {
        lifecycleScope.launch {
            viewModel._pokeDataUiState.collect { state ->
                when(state) {
                    is PokeDataUI.Success -> { setView(state.data) }
                    is PokeDataUI.Error -> {}
                    is PokeDataUI.Loading -> {}
                }
            }
        }
    }

    private fun setView(data : PokeResponse) = binding.apply {
        pokeRecycler.apply {
            val pokeAdapter = PokeAdapter(data.results)

            adapter = pokeAdapter

            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }
}