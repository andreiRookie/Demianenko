package com.andreirookie.moviesapp.network

import com.andreirookie.moviesapp.data.Movie
import com.andreirookie.moviesapp.db.MovieEntity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieNetworkEntity(
    @SerializedName("kinopoiskId")
    val kinopoiskId: Int?,

    @SerializedName("imdbId")
    val imdbId: String?,

    @SerializedName("nameRu")
    val nameRu: String?,

    @SerializedName("nameEn")
    val nameEn: String?,

    @SerializedName("nameOriginal")
    val nameOriginal: String?,

    @SerializedName("posterUrl")
    val posterUrl: String?,

    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String?,

    @SerializedName("coverUrl")
    val coverUrl: String?,

    @SerializedName("logoUrl")
    val logoUrl: String?,

    @SerializedName("reviewsCount")
    val reviewsCount: Int?,
    @SerializedName("ratingGoodReview")
    val ratingGoodReview: Double?,
    @SerializedName("ratingGoodReviewVoteCount")
    val ratingGoodReviewVoteCount: Int?,
    @SerializedName("ratingKinopoisk")
    val ratingKinopoisk: Double?,
    @SerializedName("ratingKinopoiskVoteCount")
    val ratingKinopoiskVoteCount: Int?,
    @SerializedName("ratingImdb")
    val ratingImdb: Double?,
    @SerializedName("ratingImdbVoteCount")
    val ratingImdbVoteCount: Int?,
    @SerializedName("ratingFilmCritics")
    val ratingFilmCritics: Double?,
    @SerializedName("ratingFilmCriticsVoteCount")
    val ratingFilmCriticsVoteCount: Int?,
    @SerializedName("ratingAwait")
    val ratingAwait: Double?,
    @SerializedName("ratingAwaitCount")
    val ratingAwaitCount: Int?,
    @SerializedName("ratingRfCritics")
    val ratingRfCritics: Double?,
    @SerializedName("ratingRfCriticsVoteCount")
    val ratingRfCriticsVoteCount: Int?,
    @SerializedName("webUrl")
    val webUrl: String?,
    @SerializedName("year")
    val year: Int?,
    @SerializedName("filmLength")
    val filmLength: String?,
    @SerializedName("slogan")
    val slogan: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("shortDescription")
    val shortDescription: String?,
    @SerializedName("editorAnnotation")
    val editorAnnotation: String?,
    @SerializedName("isTicketsAvailable")
    val isTicketsAvailable: Boolean?,
    @SerializedName("productionStatus")
    val productionStatus: String?,
    @SerializedName("type")
    val type: List<String>?,
    @SerializedName("ratingMpaa")
    val ratingMpaa: String?,
    @SerializedName("ratingAgeLimits")
    val ratingAgeLimits: String?,
    @SerializedName("hasImax")
    val hasImax: Boolean?,
    @SerializedName("has3D")
    val has3D: Boolean?,
    @SerializedName("lastSync")
    val lastSync: String?,
    @SerializedName("countries")
    val countries: List<Any>?,
    @SerializedName("genres")
    val genres: List<Any>?,
    @SerializedName("startYear")
    val startYear: Int?,
    @SerializedName("endYear")
    val endYear: Int?,
    @SerializedName("serial")
    val serial: Boolean?,
    @SerializedName("shortFilm")
    val shortFilm: Boolean?,
    @SerializedName("completed")
    val completed: Boolean?
)  : Serializable {
    fun toDto() = Movie(
        id = kinopoiskId ?: 0,
        title = nameRu ?: "",
        image = posterUrl ?: "",
        issueYear = year ?: 0,
        genre = genres?.toString() ?: "",
        description = description ?: "",
        country = countries?.toString() ?: ""
    )
}