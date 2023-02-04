package com.andreirookie.moviesapp.data


import java.io.Serializable

data class Movie(
    val id: Long,
    val title: String,
    val image: String = "Image",
    val issueYear: Int = 0,
    val genre: String = "Genre",
    val country: String = "Country",
    val description: String = "Descriptiotn",
    val isLiked: Boolean = false
) : Serializable
