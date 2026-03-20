package com.alilopez.kt_demohilt.core.di

import com.alilopez.demo.core.network.JsonPlaceHolderApi
import com.alilopez.kt_demohilt.BuildConfig
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
annotation class JsonPlaceHolderRetrofit

@Module
@InstallIn(SingletonComponent::class)
object JsonPlaceHolderModule {

    @JsonPlaceHolderRetrofit
    @Provides
    @Singleton
    fun provideJsonPlaceHolderRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_JSON)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideJsonPlaceHolderApiService(
        @JsonPlaceHolderRetrofit retrofit: Retrofit
    ): JsonPlaceHolderApi =
        retrofit.create(JsonPlaceHolderApi::class.java)
}