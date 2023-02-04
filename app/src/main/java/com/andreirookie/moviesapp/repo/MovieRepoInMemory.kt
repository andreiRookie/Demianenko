package com.andreirookie.moviesapp.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.andreirookie.moviesapp.data.Movie

class MovieRepoInMemory : MovieRepository {

    private var uniqueId = 0L

    private var movies = listOf<Movie>()
    init {
        repeat(10) {
            val movie = Movie(
                id = uniqueId + 1L,
                title = "Movie #${uniqueId + 1} ",
                issueYear = 2000 + 1
            )
            uniqueId++
            movies += movie
        }
    }
    private val data = MutableLiveData(movies)

    override fun getTopPopular(): LiveData<List<Movie>> {
        return data
    }

    override fun like(movieId: Long) {
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