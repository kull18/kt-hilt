package com.alilopez.kt_demohilt.features.movies.data.di

import com.kull18.cinamefilms.features.movies.data.repositories.MovieRepositoryImpl
import com.kull18.cinamefilms.features.movies.domain.repositories.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MoviesBindsModule {  // ← abstract class, no object

    @Binds
    @Singleton
    abstract fun bindMovieRepository(
        impl: MovieRepositoryImpl  // ← implementación
    ): MovieRepository             // ← interfaz
}