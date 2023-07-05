package com.semihozmen.composemovieapp.data.remote

import com.semihozmen.composemovieapp.data.remote.dto.MoviesDetailDto
import com.semihozmen.composemovieapp.data.remote.dto.MoviesDto
import com.semihozmen.composemovieapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    //http://www.omdbapi.com/?apikey=f5133d7&i=tt0372784

    //http://www.omdbapi.com/?apikey=f5133d7&t=batman


    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString :String,
        @Query("apikey") apiKey :String = API_KEY
    ) :MoviesDto

    @GET
    suspend fun getMovieDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey: String = API_KEY
    ):MoviesDetailDto

}