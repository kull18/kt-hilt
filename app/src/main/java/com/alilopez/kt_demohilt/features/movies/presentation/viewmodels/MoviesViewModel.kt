package com.kull18.cinemafilms.features.movies.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kull18.cinamefilms.features.movies.domain.entities.Movie
import com.kull18.cinemafilms.features.movies.domain.entities.MovieCategory
import com.kull18.cinemafilms.features.movies.domain.usecases.GetPopularMoviesUseCase
import com.kull18.cinemafilms.features.movies.domain.usecases.GetTopRatedMoviesUseCaese
import com.kull18.cinemafilms.features.movies.domain.usecases.GetTrendingMoviesUseCase
import com.kull18.cinemafilms.features.movies.domain.usecases.GetUpComingMoviesUseCase
import com.kull18.cinemafilms.features.movies.presentation.screens.MoviesUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getPopularMovies: GetPopularMoviesUseCase,
    private val getTopRatedMovies: GetTopRatedMoviesUseCaese,
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase,
    private val getUpComingMoviesUseCase: GetUpComingMoviesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MoviesUIState())
    val uiState = _uiState.asStateFlow()
    private val _selectedCategory = MutableStateFlow(MovieCategory.POPULAR)
    val selectedCategory = _selectedCategory.asStateFlow()
    //estado inicial nulo para la pelicula seleccionada
    private val _selectedMovie = MutableStateFlow<Movie?>(null)
    val selectedMovie =_selectedMovie.asStateFlow()

    init {
        loadMovies(MovieCategory.POPULAR)
    }

    fun selectCategory(category: MovieCategory) {
        if (_selectedCategory.value != category) {
            _selectedCategory.value = category
            loadMovies(category)
        }
    }

    private fun loadMovies(category: MovieCategory) {
        _uiState.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            val result = when (category) {
                MovieCategory.POPULAR -> getPopularMovies()
                MovieCategory.TOP_RATED -> getTopRatedMovies()
                MovieCategory.UPCOMING -> getUpComingMoviesUseCase()
                MovieCategory.TRENDING -> getTrendingMoviesUseCase()
            }

            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { list ->
                        currentState.copy(
                            isLoading = false,
                            movies = list,
                        )
                    },
                    onFailure = { error ->
                        currentState.copy(
                            isLoading = false,
                            error = error.message
                        )
                    }
                )
            }
        }
    }

    fun onSelectMovie(movie: Movie? = null) {
        _selectedMovie.update {
            movie?.copy(
                title = movie.title,
                overview = movie.overview,
                poster_path = movie.poster_path,
                releaseDate = movie.releaseDate,
                rating = movie.rating,
                backdrop_path = movie.backdrop_path,
                voteCount = movie.voteCount,
                popularity = movie.popularity
            )
        }
    }
}