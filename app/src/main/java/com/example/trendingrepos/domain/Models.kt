package com.example.trendingrepos.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(
    val id: Long,
    val title: String,
    val username: String,
    val profilePicture: String,
    val description: String,
    val stars: Int
) : Parcelable