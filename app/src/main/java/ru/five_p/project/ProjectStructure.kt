package ru.five_p.project

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProjectStructure(
    val name: String,
    val number: Int,
    val status: Boolean
) : Parcelable
