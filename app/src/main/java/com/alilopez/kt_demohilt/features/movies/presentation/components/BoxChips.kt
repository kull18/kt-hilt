package com.kull18.cinemafilms.features.movies.presentation.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kull18.cinemafilms.features.movies.domain.entities.MovieCategory

@Composable
fun BoxChips(
    modifier: Modifier = Modifier,
    selectedCategory: MovieCategory,
    onCategorySelected: (MovieCategory) -> Unit
) {
    Row(
        modifier = modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip(
            label = "Popular",
            selected = selectedCategory == MovieCategory.POPULAR,
            onClick = { onCategorySelected(MovieCategory.POPULAR) }
        )
        FilterChip(
            label = "Mejor Valoradas",
            selected = selectedCategory == MovieCategory.TOP_RATED,
            onClick = { onCategorySelected(MovieCategory.TOP_RATED) }
        )
        FilterChip(
            label = "Próximas",
            selected = selectedCategory == MovieCategory.UPCOMING,
            onClick = { onCategorySelected(MovieCategory.UPCOMING) }
        )
        FilterChip(
            label = "Tendencias",
            selected = selectedCategory == MovieCategory.TRENDING,
            onClick = { onCategorySelected(MovieCategory.TRENDING) }
        )
    }
}