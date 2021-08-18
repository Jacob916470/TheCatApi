package com.jacob.thecatapi.presentation.mainCat.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.thecatapi.domain.useCases.GetCatApiUseCase

class MainCatViewModelFactory(
    private val getCatApiUseCase: GetCatApiUseCase
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainCatViewModel(
            getCatApiUseCase
        )as T
    }
}