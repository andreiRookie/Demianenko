package com.andreirookie.moviesapp.repo

import androidx.lifecycle.LiveData
import com.andreirookie.moviesapp.data.Movie

interface MovieRepository {
    fun getTopPopular(): LiveData<List<Movie>>
    fun like(movieId: Long)
}