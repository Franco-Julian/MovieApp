package com.example.movieapp.Data.Remote

import com.example.movieapp.Aplications.AppConstants
import com.example.movieapp.Data.Model.MovieList
import com.example.movieapp.Repository.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieDataSource(private val webService: WebService) {

    lateinit var value: MovieList

    suspend fun getUpcomingMovies(): MovieList {
        withContext(Dispatchers.IO) {
            value = webService.getUpcomingMovies(AppConstants.API_KEY)
        }
        return value
    }

    suspend fun getTopRatedMovies(): MovieList {
        withContext(Dispatchers.IO) {
            value = webService.getTopRatedMovies(AppConstants.API_KEY)
        }
        return value
    }

    suspend fun getPopularMovies(): MovieList {
        withContext(Dispatchers.IO) {
            value = webService.getPopularMovies(AppConstants.API_KEY)
        }
        return value
    }
}