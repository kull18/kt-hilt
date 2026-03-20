package com.alilopez.kt_demohilt.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureNavGraph {
    fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    )
}