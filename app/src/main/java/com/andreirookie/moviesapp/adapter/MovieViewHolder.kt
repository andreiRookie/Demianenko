package com.andreirookie.moviesapp.adapter

import android.app.Activity
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.andreirookie.moviesapp.R
import com.andreirookie.moviesapp.dto.Movie
import com.andreirookie.moviesapp.databinding.MovieItemBinding
import com.bumptech.glide.Glide


class MovieViewHolder(
    private val binding: MovieItemBinding,
    private val listener: OnInteractionListener
) :RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) = with(binding) {
        titleTextView.text = movie.title
        genreTextView.text = movie.genre//root.context.getString(R.string.genres,movie.genre)
        yearTextView.text= "(${movie.issueYear})"
        likeIcon.isChecked = movie.isLiked
        Glide
            .with(root.context)
            .load(movie.image)
            .into(movieImage)

        likeIcon.setOnClickListener() {
            listener.onLikeClick(movie)
        }

        binding.root.setOnClickListener() {
            listener.onMovieItemBindingClick(movie)
        }

    }
}