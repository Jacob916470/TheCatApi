package com.jacob.thecatapi.presentation.catDetails.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.thecatapi.domain.useCases.GetCatApiUseCase

class CatDetailsViewModelFactory(
    private val getCatApiUseCase: GetCatApiUseCase
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CatDetailsViewModel(
            getCatApiUseCase
        )as T
    }
}