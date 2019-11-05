package com.stimednp.kadesubmission1

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.text.TextUtils
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.getColor
import com.stimednp.kadesubmission1.R.color.colorAccent
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by rivaldy on 11/4/2019.
 */

class LeagueUI : AnkoComponent<ViewGroup> {
    //ItemUI
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout() {
            lparams(width = matchParent, height = wrapContent)
            cardView {
                verticalLayout() {
                    lparams(matchParent, wrapContent)
                    padding = dip(8)
                    orientation = LinearLayout.VERTICAL

                    cardView {
//                        background = GradientDrawable().apply {
//                            shape = GradientDrawable.RECTANGLE
//                            cornerRadius = 8f
//                            setStroke(1, Color.MAGENTA)
//                        }
                        setCardBackgroundColor(getColor(context, colorAccent))
                        imageView {
                            id = R.id.liga_img
                            padding = dip(6)
                        }.lparams(matchParent, matchParent)
                    }.lparams(dip(50), dip(50))

                    textView {
                        id = R.id.liga_name
                        textSize = 12f
                        textColor = getColor(context, colorAccent)
                        typeface = Typeface.DEFAULT_BOLD
                    }.lparams(matchParent, wrapContent) { topMargin = dip(6) }

                    textView {
                        id = R.id.liga_desc
                        textSize = 10f
                        maxLines = 3
                        ellipsize = TextUtils.TruncateAt.END
                    }.lparams(matchParent, wrapContent)
                }
            }.lparams(matchParent, matchParent) { margin = dip(5) }
        }
    }
}