package com.alilopez.demo.features.jsonplaceholder.data.repositories

import com.alilopez.demo.core.network.JsonPlaceHolderApi
import com.alilopez.demo.features.jsonplaceholder.data.datasources.remote.mapper.toDomain
import com.alilopez.demo.features.jsonplaceholder.domain.entities.JsonPlaceHolder
import com.alilopez.demo.features.jsonplaceholder.domain.repositories.JsonPlaceHolderRepository
import javax.inject.Inject

class JsonPlaceHolderRepositoryImpl @Inject constructor(
    private val api: JsonPlaceHolderApi
) : JsonPlaceHolderRepository {

    override suspend fun getPosts(): List<JsonPlaceHolder> {
        val response = api.getPosts()
        return response.map { it.toDomain() }
    }
}