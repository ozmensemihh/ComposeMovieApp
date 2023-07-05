package com.semihozmen.composemovieapp.domain.use_case.get_movie_detail

import com.semihozmen.composemovieapp.data.remote.dto.toMovieDetail
import com.semihozmen.composemovieapp.data.remote.dto.toMovieList
import com.semihozmen.composemovieapp.domain.model.Movie
import com.semihozmen.composemovieapp.domain.model.MovieDetail
import com.semihozmen.composemovieapp.domain.repository.MovieRepository
import com.semihozmen.composemovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovieDetail(imdbID:String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.getMovieDetail(imdbID)
            if(movie.Response.equals("True")){
                emit(Resource.Success(movie.toMovieDetail()))
            }else{
                emit(Resource.Error("No Movie Found"))
            }

        }catch (e : IOError){
            emit(Resource.Error(e.localizedMessage))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage))
        }
    }

}