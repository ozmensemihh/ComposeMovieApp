package com.semihozmen.composemovieapp.data.repository

import com.semihozmen.composemovieapp.data.remote.MovieAPI
import com.semihozmen.composemovieapp.data.remote.dto.MoviesDetailDto
import com.semihozmen.composemovieapp.data.remote.dto.MoviesDto
import com.semihozmen.composemovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(private val api: MovieAPI)  :MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MoviesDetailDto {
        return api.getMovieDetail(imdbId= imdbId)
    }
}