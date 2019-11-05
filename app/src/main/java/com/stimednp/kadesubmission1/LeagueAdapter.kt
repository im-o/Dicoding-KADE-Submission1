package com.stimednp.kadesubmission1

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

/**
 * Created by rivaldy on 11/3/2019.
 */

class LeagueAdapter(
    val context: Context,
    val items: List<ItemLeagues>,
    val listener: (ItemLeagues) -> Unit
) :
    RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val ligaName: TextView = view.find(R.id.liga_name)
        private val ligaDesc: TextView = view.find(R.id.liga_desc)
        private val ligaImg: ImageView = view.find(R.id.liga_img)

        fun bindItem(itemLeagues: ItemLeagues, listener: (ItemLeagues) -> Unit) {
            ligaName.text = itemLeagues.liga_name
            ligaDesc.text = itemLeagues.liga_desc
            Glide.with(itemView.context)
                .load(itemLeagues.liga_img)
                .into(ligaImg)
            itemView.setOnClickListener {
                listener(itemLeagues)
            }
        }
    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): LeagueViewHolder {
        return LeagueViewHolder(LeagueUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

}