package com.kull18.cinemafilms.features.movies.domain.usecases

import com.kull18.cinamefilms.features.movies.domain.entities.Movie
import com.kull18.cinamefilms.features.movies.domain.repositories.MovieRepository
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
){
    suspend operator fun invoke(): Result<List<Movie>> {
        return try {
            val movies = repository.getTrendingMovies()
            val filterMovies = movies.filter { it.title.isNotBlank() }

            if(filterMovies.isEmpty()) {
                Result.failure(Exception("Error al obtener las peliculas"))
            }else {
                Result.success(filterMovies)
            }
        }catch (e: Exception) {
            Result.failure(e)
        }
    }
}