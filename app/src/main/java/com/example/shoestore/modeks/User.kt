package com.example.shoestore.modeks

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: String, var company: String, var description: String) :
    Parcelable
