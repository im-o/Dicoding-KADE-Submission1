package com.stimednp.kadesubmission1.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by rivaldy on 11/3/2019.
 */

@Parcelize
data class ItemLeagues(val liga_name: String?, val liga_desc: String?, val liga_img: Int?) :
    Parcelable