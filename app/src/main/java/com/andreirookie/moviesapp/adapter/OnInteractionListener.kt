package com.andreirookie.moviesapp.adapter

import com.andreirookie.moviesapp.dto.Movie

interface OnInteractionListener {

    fun onLikeClick(movie: Movie)

    fun onMovieItemBindingClick(movie: Movie)




}