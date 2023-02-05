package com.andreirookie.moviesapp.network

import retrofit2.Call
import retrofit2.http.GET

interface MovieApiServices {
    @GET("films")
    fun getTopFilms(): Call<List<MovieNetworkEntity>>
}