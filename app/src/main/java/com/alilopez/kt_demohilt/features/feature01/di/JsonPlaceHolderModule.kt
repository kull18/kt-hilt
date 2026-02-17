package com.alilopez.kt_demohilt.features.feature01.di

import com.alilopez.demo.core.network.JsonPlaceHolderApi
import com.alilopez.demo.features.jsonplaceholder.data.repositories.JsonPlaceHolderRepositoryImpl
import com.alilopez.demo.features.jsonplaceholder.domain.repositories.JsonPlaceHolderRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class JsonPlaceHolderModule {
    @Binds
    @Singleton
    abstract fun bindJsonPlaceHolderRepository(
        impl: JsonPlaceHolderRepositoryImpl
    ): JsonPlaceHolderRepository
}
