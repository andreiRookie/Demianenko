package com.andreirookie.moviesapp.repo

import androidx.lifecycle.LiveData
import com.andreirookie.moviesapp.data.Movie
import com.andreirookie.moviesapp.network.MovieNetworkEntity
import com.andreirookie.moviesapp.network.MovieNetworkResponse

interface MovieRepository {
    fun getAll(): LiveData<List<Movie>>
    fun like(movieId: Int)
    fun showFavorite()
    fun showAll()


    fun getTopPopular(callback: MovieCallback<MovieNetworkResponse>)
    interface MovieCallback<T> {
        fun onSuccess(value: T)
        fun onError(e: Exception)
    }
}