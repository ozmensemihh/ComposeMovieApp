package com.semihozmen.composemovieapp.presentation.movie_detail

import com.semihozmen.composemovieapp.domain.model.MovieDetail

data class MovieDetailState (
    val isLoading:Boolean = false,
    val movieDetail:MovieDetail?= null,
    val error:String = ""
        )
