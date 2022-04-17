package com.mnhyim.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Note(
    val id: Int = 0,
    val title: String,
    val content: String,
    val date: Long,
) : Parcelable