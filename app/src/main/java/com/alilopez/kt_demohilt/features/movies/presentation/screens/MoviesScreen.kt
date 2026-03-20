package com.kull18.cinemafilms.features.movies.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kull18.cinemafilms.features.movies.domain.entities.MovieCategory
import com.kull18.cinemafilms.features.movies.presentation.components.BoxChips
import com.kull18.cinemafilms.features.movies.presentation.components.FilterChip
import com.kull18.cinemafilms.features.movies.presentation.components.LazyMediaCards
import com.kull18.cinemafilms.features.movies.presentation.components.MainScaffold
import com.kull18.cinemafilms.features.movies.presentation.components.MediaCard
import com.kull18.cinemafilms.features.movies.presentation.components.TopAppBar
import com.kull18.cinemafilms.features.movies.presentation.viewmodels.MoviesViewModel

@Composable
fun MoviesScreen() {
    val viewModel: MoviesViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val selectedMovie by viewModel.selectedMovie.collectAsState()

    MainScaffold(
        topAppBar = { TopAppBar() },
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            BoxChips(
                modifier = Modifier.fillMaxWidth(),
                selectedCategory = selectedCategory,
                onCategorySelected = {category ->
                    viewModel.selectCategory(category)
                }
            )
            LazyMediaCards(
                modifier = Modifier
                    .fillMaxSize(),
                movies = uiState.movies,
                isLoading = uiState.isLoading,
                error = uiState.error,
                onSelectMovie = {movie ->
                    viewModel.onSelectMovie(movie)
                },
                selectedMovie = selectedMovie
            )
        }
    }
}
