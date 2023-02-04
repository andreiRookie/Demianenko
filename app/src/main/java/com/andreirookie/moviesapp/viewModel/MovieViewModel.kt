package com.andreirookie.moviesapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.andreirookie.moviesapp.data.Movie
import com.andreirookie.moviesapp.repo.MovieRepoInMemory
import com.andreirookie.moviesapp.repo.MovieRepository
import com.andreirookie.moviesapp.util.SingleLiveEvent

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MovieRepository = MovieRepoInMemory()

    val data = repository.getTopPopular()

    fun toLike(movieId: Long) = repository.like(movieId)

    val navigateToMovieFrag = SingleLiveEvent<Movie>()
    fun goToMovieFragment(movie: Movie) {
        navigateToMovieFrag.value = movie
    }

}