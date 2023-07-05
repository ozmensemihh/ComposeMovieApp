package com.semihozmen.composemovieapp.domain.use_case.get_movies

import com.semihozmen.composemovieapp.data.remote.dto.toMovieList
import com.semihozmen.composemovieapp.domain.model.Movie
import com.semihozmen.composemovieapp.domain.repository.MovieRepository
import com.semihozmen.composemovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MovieRepository){

    fun executeGetMovie(search:String): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = repository.getMovies(search)
            if(movies.Response.equals("True")){
                emit(Resource.Success(movies.toMovieList()))
            }else{
                emit(Resource.Error("No Movie Found"))
            }

        }catch (e : IOError){
            emit(Resource.Error(e.localizedMessage))
        }catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage))
        }
    }

}