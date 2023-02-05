package com.andreirookie.moviesapp.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.andreirookie.moviesapp.network.api.MoviesApiObj
import com.andreirookie.moviesapp.dto.Movie
import com.andreirookie.moviesapp.network.MovieNetworkResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepoInMemory : MovieRepository {

    private var uniqueId = 0
    private var movies = listOf<Movie>()
    init {
        repeat(10) {
            val movie = Movie(
                id = uniqueId + 1,
                title = "Movie #${uniqueId + 1} ",
                issueYear = 2000 + 1
            )
            uniqueId++
            movies += movie
        }
    }
    private val data = MutableLiveData(movies)

    override fun getAll(): LiveData<List<Movie>> {
        return data
    }

    override fun getTopPopular(callback: MovieRepository.MovieCallback<MovieNetworkResponse>) {
        MoviesApiObj.retrofitService.getTopPopular().enqueue(object  : Callback<MovieNetworkResponse> {
            override fun onResponse(
                call: Call<MovieNetworkResponse>,
                response: Response<MovieNetworkResponse>
            ) {
                if (!response.isSuccessful) {
                    callback.onError(RuntimeException(response.message()))
                    return
                }
                callback.onSuccess(response.body() ?: throw RuntimeException("body is null"))
            }

            override fun onFailure(call: Call<MovieNetworkResponse>, t: Throwable) {
                callback.onError(RuntimeException(t))
            }
        })
    }

    override fun like(movieId: Int) {
        movies = movies.map {
            if (it.id != movieId) it else
                it.copy(isLiked = !it.isLiked)
        }
        data.value = movies
    }

    override fun showFavorite() {
        data.value = movies.filter {it.isLiked}
    }

    override fun showAll() {
        data.value = movies
    }
}