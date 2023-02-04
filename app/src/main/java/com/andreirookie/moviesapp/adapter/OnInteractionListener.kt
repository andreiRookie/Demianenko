package com.andreirookie.moviesapp.adapter

import com.andreirookie.moviesapp.data.Movie

interface OnInteractionListener {

    fun onLikeClick(movie: Movie)

    fun onMovieItemBindingClick(movie: Movie)
}