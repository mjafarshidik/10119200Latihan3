package com.penatabahasa.latihan3.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/*
26 April 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

@Parcelize
data class User(
    val name: String?,
    val age: Int?
) : Parcelable