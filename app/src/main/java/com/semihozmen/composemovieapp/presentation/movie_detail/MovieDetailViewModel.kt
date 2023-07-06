package com.semihozmen.composemovieapp.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semihozmen.composemovieapp.domain.repository.MovieRepository
import com.semihozmen.composemovieapp.domain.use_case.get_movie_detail.GetMovieDetailUseCase
import com.semihozmen.composemovieapp.util.Constants.IMDB_ID
import com.semihozmen.composemovieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle,
    private val getMovieDetailUseCase: GetMovieDetailUseCase
    ):ViewModel() {


    private val _state = mutableStateOf<MovieDetailState>(MovieDetailState())
    val state : State<MovieDetailState> = _state

    init {
        stateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetail(it)
        }
    }

    private fun getMovieDetail(imdbId:String){
        getMovieDetailUseCase.executeGetMovieDetail(imdbId).onEach {

            when(it){
                is Resource.Success ->{_state.value  = MovieDetailState(movieDetail = it.data)
                }
                is Resource.Error ->{_state.value = MovieDetailState(error = it.message ?: "")
                }
                is Resource.Loading ->{_state.value = MovieDetailState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }

}