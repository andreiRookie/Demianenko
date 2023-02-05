package com.andreirookie.moviesapp.util

import com.andreirookie.moviesapp.dto.Movie
import com.andreirookie.moviesapp.network.MovieNetworkEntity

class MovieNetworkMapper : MovieEntityMapper<MovieNetworkEntity, Movie> {
    override fun mapFromEntity(entity: MovieNetworkEntity): Movie {
        return Movie(
            id = entity.kinopoiskId ?: 0,
            title = entity.nameRu ?: "",
            image = entity.posterUrl ?: "",
            issueYear = entity.year ?: 0,
            genre = entity.genres?.first()?.genre?.replaceFirstChar { it.uppercase() } ?: "",
//            genre = entity.genres?.joinToString { "${it.genre} " } ?: "",
            description = entity.shortDescription ?: "",
            country = entity.countries?.first()?.country?.replaceFirstChar { it.uppercase() } ?: ""
//            country = entity.countries?.joinToString { "${it.country} " } ?: ""
        )
    }

    override fun mapToEntity(movie: Movie): MovieNetworkEntity {
        TODO("Not yet implemented")
    }

    override fun mapFromEntityList(entityList: List<MovieNetworkEntity>): List<Movie> {
        return entityList.map {mapFromEntity(it)}
    }
}