package com.stimednp.kadesubmission1

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getColor
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.LayoutParams.*
import com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN
import com.stimednp.kadesubmission1.R.color.*
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.design.collapsingToolbarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.themedAppBarLayout
import org.jetbrains.anko.support.v4.nestedScrollView

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findOptional(R.id.toolbar_detail))
        val itemLeagues = intent.getParcelableExtra<ItemLeagues>(EXTRA_DATA)
        DetailActivityUI(itemLeagues!!).setContentView(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    //UI
    class DetailActivityUI(val items: ItemLeagues) : AnkoComponent<DetailActivity> {
        @SuppressLint("DefaultLocale")
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            coordinatorLayout() {
                fitsSystemWindows = true
                lparams(matchParent, matchParent)

                themedAppBarLayout(R.style.AppTheme_AppBarOverlay) {
                    id = R.id.actionbar
                    collapsingToolbarLayout {
                        setExpandedTitleColor(Color.argb(0, 0, 0, 0))
                        imageView {
                            id = R.id.liga_imgd
                            padding = dip(16)
                            Glide.with(this).load(items.liga_img).into(this)
                        }.lparams(matchParent, matchParent) {
                            collapseMode = COLLAPSE_MODE_PIN
                        }

                        view {
                            setBackgroundColor(getColor(context, colorTransparantBlack))
                        }.lparams(matchParent, matchParent)

                        toolbar {
                            id = R.id.toolbar_detail
                            popupTheme = R.style.ThemeOverlay_AppCompat_Light
                            navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_black_24dp)
                            setNavigationOnClickListener {
                                longToast("back!!, solusi min, sudah bertapa tp gk mau2")
                            }
                        }.lparams(matchParent, wrapContent) {
                            collapseMode = COLLAPSE_MODE_PIN
                        }

                    }.lparams(matchParent, dip(200)) {
                        scrollFlags =
                            SCROLL_FLAG_SCROLL or SCROLL_FLAG_SNAP or SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
                    }
                }.lparams(matchParent, wrapContent)
                nestedScrollView {
                    relativeLayout() {
                        cardView {
                            setCardBackgroundColor(getColor(context, colorAccent))
                            id = R.id.card_view
                            imageView {
                                id = R.id.liga_img
                                padding = dip(16)
                                Glide.with(this).load(items.liga_img).into(this)
                            }.lparams(matchParent, matchParent)
                        }.lparams(dip(120), dip(120)) {
                            centerHorizontally()
                        }

                        textView() {
                            id = R.id.liga_name
                            text = items.liga_name
                            textSize = 20f
                            textColor = getColor(context, colorAccent)
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            typeface = Typeface.DEFAULT_BOLD

                        }.lparams(matchParent, wrapContent) {
                            below(R.id.card_view)
                            topMargin = dip(8)
                        }
                        view {
                            id = R.id.divider_view
                            backgroundColor = getColor(context, colorTransparant2)
                        }.lparams(matchParent, dip(1)) {
                            below(R.id.liga_name)
                            topMargin = dip(8)
                        }

                        textView() {
                            id = R.id.liga_desc
                            text = items.liga_desc
                            textSize = 12f
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            typeface = Typeface.SANS_SERIF
                            textColor = getColor(context, colorTextGrey)
                        }.lparams(matchParent, wrapContent) {
                            topMargin = dip(16)
                            below(R.id.divider_view)
                        }
                    }.lparams(matchParent, matchParent) {
                        leftMargin = dip(16)
                        rightMargin = dip(16)
                        bottomMargin = dip(24)
                        topMargin = dip(24)
                    }
                }.lparams(matchParent, matchParent) {
                    behavior = AppBarLayout.ScrollingViewBehavior()
                }
            }
        }
    }
}
