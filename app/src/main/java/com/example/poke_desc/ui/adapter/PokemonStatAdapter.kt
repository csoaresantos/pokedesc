package com.example.poke_desc.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poke_desc.R
import com.example.poke_desc.data.model.Stat
import kotlinx.android.synthetic.main.stat_row.view.*

class PokemonStatAdapter(
    private val stats: ArrayList<Stat>
) : RecyclerView.Adapter<PokemonStatAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(stat: Stat) {
            itemView.name.text = stat.stat.name
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