package com.kull18.cinemafilms.features.movies.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kull18.cinamefilms.features.movies.domain.entities.Movie
import com.kull18.cinemafilms.core.data.utils.ImageUtils


@Composable
fun LazyMediaCards(
    modifier: Modifier = Modifier,
    movies: List<Movie>,
    onSelectMovie: (Movie?) -> Unit,
    selectedMovie: Movie?,
    isLoading: Boolean,
    error: String?
) {

    Box(modifier = modifier.fillMaxWidth()) {
        when {
            isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                }
            }

            error != null -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Error: $error",
                        color = Color.White
                    )
                }
            }

            movies.isEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No hay películas disponibles",
                        color = Color.White
                    )
                }
            }

            else -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(movies) { movie ->
                        MediaCard(
                            poster = ImageUtils.getPosterUrl(movie.poster_path),
                            title = movie.title,
                            rating = movie.rating,
                            year = movie.releaseDate.take(4).toIntOrNull() ?: 0,
                            onClick = { onSelectMovie(movie) }
                        )
                    }
                }
            }
        }
    }

    selectedMovie?.let { movie ->
        MovieDetailModal(
            poster = ImageUtils.getPosterUrl(movie.poster_path),
            backdrop = ImageUtils.getBackdropUrl(movie.backdrop_path),
            title = movie.title,
            year = movie.releaseDate.take(4).toIntOrNull() ?: 0,
            rating = movie.rating,
            voteCount = movie.voteCount,
            popularity = movie.popularity,
            synopsis = movie.overview,
            onDismiss = { onSelectMovie(null) }
        )
    }
}