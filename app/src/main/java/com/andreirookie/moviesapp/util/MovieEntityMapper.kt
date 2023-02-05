package com.andreirookie.moviesapp.util

interface MovieEntityMapper<MovieNetworkEntity, Movie> {
    fun mapFromEntity(entity: MovieNetworkEntity): Movie
    fun mapToEntity(movie: Movie) : MovieNetworkEntity
    fun mapFromEntityList(entityList: List<MovieNetworkEntity>): List<Movie>
}