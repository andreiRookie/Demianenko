package com.andreirookie.moviesapp.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.andreirookie.moviesapp.dto.Movie
import com.andreirookie.moviesapp.db.MovieEntity.Companion.fromDto

class LocalDbImpl(
    private val dao: MovieDao
) : LocalDbInterface {

    override fun removeById(movieId: Int) {
        dao.remove(movieId)
    }

    override fun add(movie: Movie) {
        dao.insert(fromDto(movie))
    }

    override fun getSaved():List<Movie> {
        return dao.getAllSaved().map { it.toDto() }
    }


}