package com.andreirookie.moviesapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.andreirookie.moviesapp.dto.Movie

@Entity
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val image: String,
    val issueYear: Int,
    val genre: String="",
    val country: String="",
    val description: String,
    val isLiked: Boolean
) {
    fun toDto() =
        Movie(id,title,image, issueYear, genre, country, description, isLiked)

    companion object {
        fun fromDto(dto: Movie) =
            MovieEntity(dto.id, dto.title, dto.image, dto.issueYear, dto.genre, dto.country, dto.description, dto.isLiked)

    }
}
