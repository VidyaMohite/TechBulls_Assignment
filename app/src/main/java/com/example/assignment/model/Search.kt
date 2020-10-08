package com.example.assignment.model
/*
* Dev - Vidya Jadav - 07/10/2020
* */
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Search(
    @Expose
    @SerializedName("Search")
    val movieData:List<MovieData>? = null,
   )
