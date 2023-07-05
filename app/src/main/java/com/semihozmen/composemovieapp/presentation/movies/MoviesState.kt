package com.semihozmen.composemovieapp.presentation.movies

import com.semihozmen.composemovieapp.domain.model.Movie

data class MoviesState (
    val isLoading :Boolean = false,
    val movies:List<Movie> = emptyList(),
    val error:String = "",
    val search :String="batman") {
}