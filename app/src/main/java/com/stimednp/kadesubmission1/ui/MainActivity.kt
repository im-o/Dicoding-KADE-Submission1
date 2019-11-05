package com.stimednp.kadesubmission1.ui

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.LayoutParams.*
import com.stimednp.kadesubmission1.R
import com.stimednp.kadesubmission1.adapter.LeagueAdapter
import com.stimednp.kadesubmission1.data.ItemLeagues
import org.jetbrains.anko.*
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.themedAppBarLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    var itemLeagues: MutableList<ItemLeagues> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findOptional(R.id.toolbar))

        initData()
        MainActivityUI(itemLeagues).setContentView(this)
    }

    class MainActivityUI(val items: List<ItemLeagues>) : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            coordinatorLayout {
                fitsSystemWindows = true
                themedAppBarLayout(R.style.AppTheme_AppBarOverlay) {
                    toolbar {
                        id = R.id.toolbar
                        title = resources.getString(R.string.title_app)
                        setTitleTextColor(Color.WHITE)
                    }.lparams(matchParent, wrapContent) {
                        scrollFlags = SCROLL_FLAG_SCROLL or SCROLL_FLAG_ENTER_ALWAYS
                    }
                }.lparams(matchParent, wrapContent)

                frameLayout {
                    recyclerView {
                        lparams(matchParent, wrapContent)
                        layoutManager = LinearLayoutManager(context)
                        adapter =
                            LeagueAdapter(context, items) {
                                startActivity<DetailActivity>(DetailActivity.EXTRA_DATA to it)
                            }
                    }
                }.lparams(matchParent, matchParent) {
                    behavior = AppBarLayout.ScrollingViewBehavior()
                }
            }
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.league_name)
        val desc = resources.getStringArray(R.array.league_desc)
        val img = resources.obtainTypedArray(R.array.league_img)

        itemLeagues.clear()
        for (i in name.indices) {
            itemLeagues.add(
                ItemLeagues(
                    name[i],
                    desc[i],
                    img.getResourceId(i, 0)
                )
            )
        }
        //Recycle the typed array
        img.recycle()
    }
}
