package com.alilopez.kt_demohilt.features.feature01.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alilopez.demo.features.jsonplaceholder.presentation.screens.JsonPlaceHolderScreen
import com.alilopez.kt_demohilt.core.navigation.FeatureNavGraph
import com.alilopez.kt_demohilt.core.navigation.JsonPlaceHolder
import com.alilopez.kt_demohilt.core.navigation.Movies
import javax.inject.Inject

class JsonPlaceHolderNavGraph @Inject constructor() : FeatureNavGraph {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    ) {
        navGraphBuilder.composable<JsonPlaceHolder> {
            JsonPlaceHolderScreen(
                onNavigateToMovies = {
                    navController.navigate(Movies)
                }
            )
        }
    }
}