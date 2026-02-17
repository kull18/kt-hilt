package com.alilopez.demo.features.jsonplaceholder.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alilopez.demo.features.jsonplaceholder.domain.usecases.GetJsonPlaceHolderUseCase
import com.alilopez.demo.features.jsonplaceholder.presentation.screens.JsonPlaceHolderUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class JsonPlaceHolderViewModel @Inject constructor(
    private val getJsonPlaceHolderUseCase: GetJsonPlaceHolderUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(JsonPlaceHolderUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getJsonPlaceHolderUseCase()
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { list ->
                        currentState.copy(isLoading = false, characters = list)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }
}