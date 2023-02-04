package com.andreirookie.moviesapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.andreirookie.moviesapp.data.Movie
import com.andreirookie.moviesapp.db.AppDb
import com.andreirookie.moviesapp.db.LocalDbImpl
import com.andreirookie.moviesapp.db.LocalDbInterface
import com.andreirookie.moviesapp.db.MovieDao
import com.andreirookie.moviesapp.repo.MovieRepoInMemory
import com.andreirookie.moviesapp.repo.MovieRepository
import com.andreirookie.moviesapp.util.SingleLiveEvent

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val repositoryInMemory: MovieRepository = MovieRepoInMemory()
    private val repositoryLocal: LocalDbInterface = LocalDbImpl(
        AppDb.getInstance(context = application).movieDao()
    )

    val data = repositoryInMemory.getTopPopular()
    val savedData = repositoryLocal.getSaved()

    fun toLike(movie: Movie) {
        repositoryLocal.add(movie)
        repositoryInMemory.like(movie.id)
    }

    val navigateToMovieFragEvent = SingleLiveEvent<Movie>()
    fun goToMovieFragment(movie: Movie) {
        navigateToMovieFragEvent.value = movie
    }

    fun showFavorites() = repositoryInMemory.showFavorite()
    fun showAll() = repositoryInMemory.showAll()



}