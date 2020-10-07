package com.example.assignment.model

import com.google.gson.annotations.SerializedName

data class MovieData(
    @SerializedName("Title") val name:String? = null,
    @SerializedName("Year") val year:String? = null,
    @SerializedName("Poster") val image:String? = null) {
}