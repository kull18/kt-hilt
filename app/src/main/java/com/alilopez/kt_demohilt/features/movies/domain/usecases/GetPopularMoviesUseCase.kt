package com.kull18.cinemafilms.features.movies.domain.usecases

import com.kull18.cinamefilms.features.movies.domain.entities.Movie
import com.kull18.cinamefilms.features.movies.domain.repositories.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(): Result<List<Movie>> {
        return try {
            val movies = repository.getPopularMovies()

            val filterMovie = movies.filter { it.title.isNotBlank() }

            if(filterMovie.isEmpty()) {
                Result.failure(Exception("error al obtener los datos de las peliculas"))
            }else {
                Result.success(filterMovie)
            }
        }catch (e: Exception) {
            Result.failure(e)
        }
    }
}