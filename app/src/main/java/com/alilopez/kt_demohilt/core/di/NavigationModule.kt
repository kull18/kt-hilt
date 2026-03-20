package com.alilopez.kt_demohilt.core.di

import com.alilopez.kt_demohilt.core.navigation.FeatureNavGraph
import com.alilopez.kt_demohilt.features.feature01.navigation.JsonPlaceHolderNavGraph
import com.alilopez.kt_demohilt.features.movies.navigation.MoviesNavGraph
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @IntoSet
    fun provideJsonPlaceHolderNavGraph(
        graph: JsonPlaceHolderNavGraph
    ): FeatureNavGraph = graph

    @Provides
    @IntoSet
    fun provideMoviesNavGraph(
        graph: MoviesNavGraph
    ): FeatureNavGraph = graph
}