package com.semihozmen.composemovieapp.data.di

import com.semihozmen.composemovieapp.data.remote.MovieAPI
import com.semihozmen.composemovieapp.data.repository.MovieRepositoryImp
import com.semihozmen.composemovieapp.domain.repository.MovieRepository
import com.semihozmen.composemovieapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api : MovieAPI):MovieRepository{
        return MovieRepositoryImp(api)
    }

}