package com.alilopez.demo.features.jsonplaceholder.presentation.screens

import com.alilopez.demo.features.jsonplaceholder.domain.entities.JsonPlaceHolder

data class JsonPlaceHolderUiState(
    val isLoading: Boolean = false,
    val characters: List<JsonPlaceHolder> = emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false
)