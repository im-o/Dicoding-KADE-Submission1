package com.stimednp.kadesubmission1

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

/**
 * Created by rivaldy on 11/3/2019.
 */

class LeagueAdapter(val context: Context, val items: List<ItemLeagues>) :
    RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {
    //layout UI

    class LeagueUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                verticalLayout() {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.VERTICAL

                    imageView {
                        id = R.id.liga_img
                    }.lparams(width = dip(50), height = dip(50))

                    textView {
                        id = R.id.liga_name
                        textSize = 16f
                    }.lparams {
                        width = matchParent
                        margin = dip(16)
                    }

                    textView {
                        id = R.id.liga_desc
                        textSize = 16f
                        maxLines = 3

                    }.lparams {
                        width = matchParent
                        margin = dip(16)
                    }
                }
            }
        }
    }

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val ligaImg: ImageView = view.find(R.id.liga_img)
        private val ligaName: TextView = view.find(R.id.liga_name)
        private val ligaDesc: TextView = view.find(R.id.liga_desc)

        fun bindItem(itemLeagues: ItemLeagues) {
            Glide.with(itemView.context)
                .load(itemLeagues.liga_img)
                .into(ligaImg)
            ligaName.text = itemLeagues.liga_name
            ligaDesc.text = itemLeagues.liga_desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(LeagueUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

}