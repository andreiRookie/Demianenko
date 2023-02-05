package com.andreirookie.moviesapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.andreirookie.moviesapp.dto.Movie
import com.andreirookie.moviesapp.db.AppDb
import com.andreirookie.moviesapp.db.LocalDbImpl
import com.andreirookie.moviesapp.db.LocalDbInterface
import com.andreirookie.moviesapp.util.MovieNetworkMapper
import com.andreirookie.moviesapp.network.MovieNetworkResponse
import com.andreirookie.moviesapp.repo.MovieRepoInMemory
import com.andreirookie.moviesapp.repo.MovieRepository
import com.andreirookie.moviesapp.stateModel.StateModel
import com.andreirookie.moviesapp.util.SingleLiveEvent

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val repositoryInMemory: MovieRepository = MovieRepoInMemory()
    private val repositoryLocal: LocalDbInterface = LocalDbImpl(
        AppDb.getInstance(context = application).movieDao()
    )
    private val mapper = MovieNetworkMapper()

    private val _dataFromWeb = MutableLiveData(StateModel())
    val dataFromWeb: LiveData<StateModel>
        get() = _dataFromWeb

    fun loadPopular() {
        _dataFromWeb.postValue(StateModel(loading = true))

        repositoryInMemory.getTopPopular(object : MovieRepository.MovieCallback<MovieNetworkResponse> {
            override fun onSuccess(response: MovieNetworkResponse) {
                _dataFromWeb.postValue(StateModel(
                    movies = mapper.mapFromEntityList(response.movies),
                    empty = response.movies.isEmpty()))
            }

            override fun onError(e: Exception) {
                println("fun onError ${e.message}")
                _dataFromWeb.postValue(StateModel(error = true))
            }
        })
    }

    fun toLike(movie: Movie) {
//        repositoryLocal.add(movie)
        repositoryInMemory.like(movie.id)
    }

    val navigateToMovieFragEvent = SingleLiveEvent<Movie>()
    fun goToMovieFragment(movie: Movie) {
        navigateToMovieFragEvent.value = movie
    }

    fun showFavorites() {
        _dataFromWeb.postValue(StateModel(movies =repositoryLocal.getSaved() ))
        repositoryInMemory.showFavorite()
    }
    fun showAll() = repositoryInMemory.showAll()

}