package com.kull18.cinamefilms.features.movies.domain.repositories

import com.kull18.cinamefilms.features.movies.domain.entities.Movie

interface MovieRepository {

    suspend fun getPopularMovies(): List<Movie>
    suspend fun getTrendingMovies(): List<Movie>
    suspend fun getTopRatedMovies(): List<Movie>
    suspend fun getUpcomingMovies(): List<Movie>
}