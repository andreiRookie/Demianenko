package com.andreirookie.moviesapp.dto

import java.io.Serializable

data class Movie(
    val id: Int,
    val title: String,
    val image: String = "Image",
    val issueYear: Int = 0,
    val genre: String ="",
    val country: String ="",
    val description: String = "Descriptiotn",
    val isLiked: Boolean = false
) : Serializable
