package com.semihozmen.composemovieapp.domain.model

import com.semihozmen.composemovieapp.data.remote.dto.Rating

data class MovieDetail(
    val Actors: String,
    val Awards: String,
    val Country: String,
    val Director: String,
    val Language: String,
    val Poster: String,
    val Production: String,
    val Released: String,
    val Title: String,
    val Type: String,
    val Writer: String,
    val Year: String,
    val imdbRating: String
)
