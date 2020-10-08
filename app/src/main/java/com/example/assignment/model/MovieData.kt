package com.example.assignment.model
/*
* Dev - Vidya Jadav - 07/10/2020
* */
import com.google.gson.annotations.SerializedName

data class MovieData (
    @SerializedName("Title")
    val name:String? = null,

    @SerializedName("Year")
    val year:String? = null,

    @SerializedName("Poster")
    val image:String? = null,

    @SerializedName("imdbID")
    val imdbID:String? = null,

    @SerializedName("Type")
    val Type:String? = null)