package com.semihozmen.composemovieapp.presentation.movies

sealed class MoviesEvent {
    data class Search(val search :String):MoviesEvent()
}