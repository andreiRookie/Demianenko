package com.andreirookie.moviesapp.network.api

import com.andreirookie.moviesapp.network.MovieNetworkResponse
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*

private const val BASE_URL = "https://kinopoiskapiunofficial.tech"
private const val API_KEY = "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b"

private val loggingInterceptor = HttpLoggingInterceptor().apply {
    HttpLoggingInterceptor.Level.BODY.also { this.level = it }
}

private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .build()

interface MoviesApiService {
    @Headers("X-API-KEY: $API_KEY")
    @GET(value = "/api/v2.2/films/top?type=TOP_100_POPULAR_FILMS")
    fun getTopPopular(): Call<MovieNetworkResponse>

//    @GET("films")
//    fun getTopFilms(): Call<List<MovieNetworkEntity>>
}

object MoviesApiObj {
    val retrofitService by lazy {
//        retrofit.create(MoviesApiService::class.java)
        retrofit.create<MoviesApiService>()
    }
}