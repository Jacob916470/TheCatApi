package com.jacob.thecatapi.presentation.mainCat.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.thecatapi.data.network.models.breeds.TheCatApiResponseItem
import com.jacob.thecatapi.domain.useCases.GetCatApiUseCase
import com.jacob.thecatapi.presentation.core.callBack.ResultCallBack

class MainCatViewModelFactory(
    private val getCatApiUseCase: GetCatApiUseCase,
    private val resultCallBack: ResultCallBack<TheCatApiResponseItem>
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainCatViewModel(
            getCatApiUseCase,
            resultCallBack
        )as T
    }
}