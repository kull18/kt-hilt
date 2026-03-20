package com.alilopez.kt_demohilt.features.movies.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alilopez.kt_demohilt.core.navigation.FeatureNavGraph
import com.alilopez.kt_demohilt.core.navigation.Movies
import com.kull18.cinemafilms.features.movies.presentation.screens.MoviesScreen
import javax.inject.Inject

class MoviesNavGraph @Inject constructor() : FeatureNavGraph {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    ) {
        navGraphBuilder.composable<Movies> {
            MoviesScreen()
        }
    }
}