package com.andreirookie.moviesapp.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.andreirookie.moviesapp.data.Movie
import com.andreirookie.moviesapp.db.MovieEntity.Companion.fromDto

class LocalDbImpl(
    private val dao: MovieDao
) : LocalDbInterface {
//    private val savedData = dao.getAllSaved()
    override fun removeById(movieId: Long) {
        dao.remove(movieId)
    }

    override fun add(movie: Movie) {
        dao.insert(fromDto(movie))
    }

    override fun getSaved(): LiveData<List<Movie>> =
        Transformations.map(dao.getAllSaved()) { list ->
            list.map { it.toDto() }
        }
}