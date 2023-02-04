package com.andreirookie.moviesapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.andreirookie.moviesapp.data.Movie
import com.andreirookie.moviesapp.databinding.MovieItemBinding

class MovieViewHolder(
    private val binding: MovieItemBinding,
    private val listener: OnInteractionListener
) :RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) = with(binding) {
        titleTextView.text = movie.title
        genreTextView.text = movie.genre
        yearTextView.text= "${movie.issueYear}"
        likeIcon.isChecked = movie.isLiked

        likeIcon.setOnClickListener() {
            listener.onLikeClick(movie)
        }

        binding.root.setOnClickListener() {
            listener.onMovieItemBindingClick(movie)
        }

    }
}