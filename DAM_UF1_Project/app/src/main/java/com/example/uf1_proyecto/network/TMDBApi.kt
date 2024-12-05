package com.example.uf1_proyecto.network

import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {
    @GET("discover/movie")
    suspend fun getMoviesByGenre(
        @Query("api_key") apiKey: String,
        @Query("with_genres") genreId: Int,
        @Query("page") page: Int = 1
    ): TMDBResponse
}