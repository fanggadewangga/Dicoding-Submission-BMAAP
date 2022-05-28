package com.submission.BMAS.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fruit(
    val name : String,
    val scientificName : String,
    val description : String,
    val region : String,
    val soil : String,
    val temperature : String,
    val fruitImage : Int
    ) :  Parcelable
