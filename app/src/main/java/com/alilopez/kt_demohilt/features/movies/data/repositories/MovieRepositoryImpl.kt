package com.kull18.cinamefilms.features.movies.data.repositories


import com.alilopez.kt_demohilt.core.di.TmdbApiKey
import com.alilopez.kt_demohilt.core.network.MovieApi
import com.kull18.cinamefilms.features.movies.data.datasources.mapper.toDomain
import com.kull18.cinamefilms.features.movies.domain.entities.Movie
import com.kull18.cinamefilms.features.movies.domain.repositories.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    val repository: MovieApi,
    @TmdbApiKey private val apiKey: String
): MovieRepository  {
    override suspend fun getPopularMovies(): List<Movie> {
        val movies = repository.getPopularMovies(apiKey)
        return movies.results.map { it.toDomain() }
    }

    override suspend fun getTrendingMovies(): List<Movie> {
        val movies = repository.getTrendingMovies(apiKey)
        return movies.results.map { it.toDomain() }
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        val movies = repository.getTrendingMovies(apiKey)
        return movies.results.map { it.toDomain() }
    }

    override suspend fun getUpcomingMovies(): List<Movie> {
        val movies = repository.getUpcomingMovies(apiKey)
        return movies.results.map { it.toDomain() }
    }
}