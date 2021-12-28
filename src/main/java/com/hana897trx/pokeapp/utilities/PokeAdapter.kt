package com.hana897trx.pokeapp.utilities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hana897trx.pokeapp.databinding.ItemPokeBinding
import com.hana897trx.pokeapp.model.PokeModel

class PokeAdapter (
    private var pokeData : List<PokeModel> = listOf<PokeModel>()
) : RecyclerView.Adapter<PokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PokeViewHolder(
            ItemPokeBinding.inflate(
                LayoutInflater.from(
                    parent.context,
                ),
                parent,
                false
            )
        )

    override fun getItemCount() =
        pokeData.size

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        holder.setView(pokeData[position])
    }
}