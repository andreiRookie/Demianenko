package com.andreirookie.moviesapp.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.andreirookie.moviesapp.R
import com.andreirookie.moviesapp.dto.Movie
import com.andreirookie.moviesapp.databinding.MovieFragmentBinding
import com.andreirookie.moviesapp.util.MovieArg
import com.bumptech.glide.Glide

class MovieFragment : Fragment() {

//    private val viewModel by viewModels<MovieViewModel> (::requireParentFragment)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = MovieFragmentBinding.inflate(inflater, container, false)

        with(binding) {
            arguments?.movieArg?.let {
                movieTitle.text = it.title
                movieDescription.text = it.description
                movieCountry.text = getString(R.string.country, it.country)
                movieGenre.text = getString(R.string.genres, it.genre)

                Glide.with(root)
                    .load(it.image)
                    .into(moviePosterImage)
            }
        }

        binding.toBackImageView.setOnClickListener {
            findNavController().navigateUp()
        }



        return binding.root
    }

    companion object {
        var Bundle.movieArg: Movie by MovieArg
    }
}