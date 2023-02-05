package com.andreirookie.moviesapp.repo

import androidx.lifecycle.LiveData
import com.andreirookie.moviesapp.dto.Movie
import com.andreirookie.moviesapp.network.MovieNetworkResponse

interface MovieRepository {
    fun getAll(): LiveData<List<Movie>>
    fun like(movieId: Int)
    fun showFavorite()
    fun showAll()


    fun getTopPopular(callback: MovieCallback<MovieNetworkResponse>)
    interface MovieCallback<T> {
        fun onSuccess(response: T)
        fun onError(e: Exception)
    }
}