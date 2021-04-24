package com.dicoding.mysubmission

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Medicine(
    var name: String = "",
    var detail: String = "",
    var photo: Int = 0
) : Parcelable
