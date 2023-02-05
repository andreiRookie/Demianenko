package com.andreirookie.moviesapp.stateModel

import com.andreirookie.moviesapp.dto.Movie

data class StateModel(
    val movies: List<Movie> = emptyList(),
    val loading: Boolean = false,
    val empty: Boolean = false,
    val refreshing: Boolean = false,
    val error: Boolean = false
)
