package com.alilopez.kt_demohilt.core.di

import com.alilopez.kt_demohilt.BuildConfig
import com.alilopez.kt_demohilt.core.network.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TmdbApiKey

@Module
@InstallIn(SingletonComponent::class)
object MoviesModule {

    @TmdbApiKey
    @Provides
    @Singleton
    fun provideTmdbApiKey(): String = BuildConfig.TMDB_API_KEY  // ← DENTRO del object

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.MOVIES_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)
}