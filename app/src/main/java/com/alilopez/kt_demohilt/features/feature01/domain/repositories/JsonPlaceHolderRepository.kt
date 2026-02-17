package com.alilopez.demo.features.jsonplaceholder.domain.repositories

import com.alilopez.demo.features.jsonplaceholder.domain.entities.JsonPlaceHolder



interface JsonPlaceHolderRepository {
    suspend fun getPosts(): List<JsonPlaceHolder>
}