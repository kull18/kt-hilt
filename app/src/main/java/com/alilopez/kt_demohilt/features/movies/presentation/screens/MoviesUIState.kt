package com.kull18.cinemafilms.features.movies.presentation.screens

import com.kull18.cinamefilms.features.movies.domain.entities.Movie


data class MoviesUIState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val movies: List<Movie> = emptyList(),
    val isRefreshing: Boolean = false
)