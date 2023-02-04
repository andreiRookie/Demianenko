package com.andreirookie.moviesapp.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.andreirookie.moviesapp.R
import com.andreirookie.moviesapp.adapter.MovieAdapter
import com.andreirookie.moviesapp.adapter.OnInteractionListener
import com.andreirookie.moviesapp.data.Movie
import com.andreirookie.moviesapp.databinding.FeedFragmentBinding
import com.andreirookie.moviesapp.frags.MovieFragment.Companion.movieArg
import com.andreirookie.moviesapp.viewModel.MovieViewModel

class FeedFragment : Fragment() {

    private val viewModel by viewModels<MovieViewModel>(ownerProducer = ::requireParentFragment)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding =FeedFragmentBinding.inflate(inflater, container, false)

        val adapter = MovieAdapter(
            object  : OnInteractionListener {
                override fun onLikeClick(movie: Movie) {
                    viewModel.toLike(movie)
                }

                override fun onMovieItemBindingClick(movie: Movie) {
                    viewModel.goToMovieFragment(movie)
                }


            }
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        val simpleItemAnimator = binding.recyclerView.itemAnimator as SimpleItemAnimator
        simpleItemAnimator.supportsChangeAnimations = false

        viewModel.navigateToMovieFragEvent.observe(viewLifecycleOwner) {
            findNavController().navigate(
                R.id.from_feedFragment_to_movieFragment,
                Bundle().apply { movieArg = it }
            )
        }

        binding.favoriteButton.setOnClickListener{
            viewModel.showFavorites()
        }

        binding.popularButton.setOnClickListener {
            viewModel.showAll()
        }





        return binding.root
    }




}