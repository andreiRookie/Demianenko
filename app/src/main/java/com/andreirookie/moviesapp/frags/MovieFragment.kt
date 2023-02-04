package com.andreirookie.moviesapp.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.andreirookie.moviesapp.data.Movie
import com.andreirookie.moviesapp.databinding.MovieFragmentBinding
import com.andreirookie.moviesapp.util.MovieArg
import com.andreirookie.moviesapp.viewModel.MovieViewModel

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
                movieCountry.text = it.country
                movieGenre.text = it.genre

            }
        }



        return binding.root
    }

    companion object {
        var Bundle.movieArg: Movie by MovieArg
    }
}