package com.andreirookie.moviesapp.network

import com.andreirookie.moviesapp.data.Movie
import com.andreirookie.moviesapp.util.MovieEntityMapper

class MovieNetworkMapper : MovieEntityMapper<MovieNetworkEntity, Movie> {
    override fun mapFromEntity(entity: MovieNetworkEntity): Movie {
        return Movie(
            id = entity.kinopoiskId ?: 0,
            title = entity.nameRu ?: "",
            image = entity.posterUrl ?: "",
            issueYear = entity.year ?: 0,
            genre = entity.genres?.toString() ?: "",
            description = entity.description ?: "",
            country = entity.countries?.toString() ?: ""
        )
    }

    override fun mapToEntity(movie: Movie): MovieNetworkEntity {
        TODO("Not yet implemented")
    }

    override fun mapFromEntityList(entityList: List<MovieNetworkEntity>): List<Movie> {
        return entityList.map {mapFromEntity(it)}
    }
}