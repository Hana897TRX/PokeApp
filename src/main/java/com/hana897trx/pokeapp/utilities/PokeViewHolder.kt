package com.hana897trx.pokeapp.utilities

import androidx.recyclerview.widget.RecyclerView
import com.hana897trx.pokeapp.databinding.ItemPokeBinding
import com.hana897trx.pokeapp.model.PokeModel

class PokeViewHolder(
    val binding: ItemPokeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setView(pokeData : PokeModel) = binding.apply {
        itemPokeName.text = pokeData.name
    }
}