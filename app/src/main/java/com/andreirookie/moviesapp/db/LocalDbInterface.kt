package com.andreirookie.moviesapp.db

import androidx.lifecycle.LiveData
import com.andreirookie.moviesapp.dto.Movie

interface LocalDbInterface {
    fun removeById(movieId: Int)
    fun add(movie: Movie)
    fun getSaved(): List<Movie>

}