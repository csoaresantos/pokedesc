package com.example.poke_desc.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.poke_desc.R
import com.example.poke_desc.data.model.Pokemon
import com.example.poke_desc.data.model.Stat
import com.example.poke_desc.ui.viewmodel.PokemonViewModel
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.stat_row.view.*

class PokemonStatAdapter(
    private val stats: ArrayList<Stat>
) : RecyclerView.Adapter<PokemonStatAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(stat: Stat) {
            itemView.name.text = stat.stat.name
            //itemView.progressBar.progress = stat.baseStat.toInt()
            itemView.baseStat.text = stat.base_stat.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.stat_row, parent, false
            )
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(stats[position])
    }

    override fun getItemCount(): Int = stats.size

    fun addData(statList: List<Stat>) {
        stats.addAll(statList)
    }
}