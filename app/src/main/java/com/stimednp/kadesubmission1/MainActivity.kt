package com.stimednp.kadesubmission1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    var itemLeagues: MutableList<ItemLeagues> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //generateLayout
        initData()
        MainActivityUI(itemLeagues).setContentView(this)
    }
    class MainActivityUI(val items: List<ItemLeagues>): AnkoComponent<MainActivity>{
        override fun createView(ui: AnkoContext<MainActivity>): View {
            return with(ui){
                verticalLayout {
                    lparams(matchParent, wrapContent)
                    recyclerView {
                        lparams(matchParent, wrapContent)
                        layoutManager = LinearLayoutManager(context)
                        adapter = LeagueAdapter(context, items)
                    }
                }
            }
        }
    }


    private fun initData() {
        val name = resources.getStringArray(R.array.league_name)
        val desc = resources.getStringArray(R.array.league_desc)
        val img = resources.obtainTypedArray(R.array.league_img)

        itemLeagues.clear()
        for (i in name.indices){
            itemLeagues.add(ItemLeagues(name[i], desc[i], img.getResourceId(i,0)))
        }
        //Recycle the typed array
        img.recycle()
    }
}
