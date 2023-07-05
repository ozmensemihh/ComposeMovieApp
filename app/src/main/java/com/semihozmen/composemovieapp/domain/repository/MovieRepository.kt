package com.semihozmen.composemovieapp.domain.repository

import com.semihozmen.composemovieapp.data.remote.dto.MoviesDetailDto
import com.semihozmen.composemovieapp.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search:String):MoviesDto
    suspend fun  getMovieDetail(imdbId :String):MoviesDetailDto
}