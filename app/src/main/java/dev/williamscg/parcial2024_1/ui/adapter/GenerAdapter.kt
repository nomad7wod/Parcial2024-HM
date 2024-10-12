package dev.williamscg.parcial2024_1.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.williamscg.parcial2024_1.R
import dev.williamscg.parcial2024_1.ui.model.GenerModel

class GenerAdapter(private val lstGener: List<GenerModel>) :
    RecyclerView.Adapter<GenerAdapter.ViewHolder>() {
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val ivGener = itemView.findViewById<ImageView>(R.id.ivGener)
            val tvGener = itemView.findViewById<TextView>(R.id.tvGener)
            val tvAnio = itemView.findViewById<TextView>(R.id.tvAnio)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_gener, parent, false))

    }
    override fun getItemCount(): Int {
        return lstGener.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemGener = lstGener[position]
        holder.ivGener.setImageResource(itemGener.image)
        holder.tvGener.text = itemGener.name
        holder.tvAnio.text = itemGener.year
    }

    }

