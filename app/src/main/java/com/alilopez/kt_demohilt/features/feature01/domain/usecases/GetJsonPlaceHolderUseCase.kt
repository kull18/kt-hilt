package com.alilopez.demo.features.jsonplaceholder.domain.usecases

import com.alilopez.demo.features.jsonplaceholder.domain.entities.JsonPlaceHolder
import com.alilopez.demo.features.jsonplaceholder.domain.repositories.JsonPlaceHolderRepository
import com.alilopez.kt_demohilt.features.feature01.di.JsonPlaceHolderModule
import javax.inject.Inject

class GetJsonPlaceHolderUseCase @Inject constructor(
    private val repository: JsonPlaceHolderRepository
) {
    suspend operator fun invoke(): Result<List<JsonPlaceHolder>> {
        return try {
            val characters = repository.getPosts()

            val filteredCharacters = characters.filter { it.title.isNotBlank() }

            if (filteredCharacters.isEmpty()) {
                Result.failure(Exception("No se encontraron personajes válidos"))
            } else {
                Result.success(filteredCharacters)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}