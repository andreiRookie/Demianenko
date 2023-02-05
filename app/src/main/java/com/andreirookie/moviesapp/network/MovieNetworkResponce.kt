package com.andreirookie.moviesapp.network

import com.google.gson.annotations.SerializedName

data class MovieNetworkResponse (
//    @SerializedName("pagesCount")
//    val pagesCount: Int,

    @SerializedName("films")
    val movies: List<MovieNetworkEntity>
){}