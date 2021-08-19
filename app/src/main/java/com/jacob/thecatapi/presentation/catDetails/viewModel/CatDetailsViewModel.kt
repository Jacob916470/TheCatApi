package com.jacob.thecatapi.presentation.catDetails.viewModel

import androidx.lifecycle.MutableLiveData
import com.jacob.thecatapi.data.network.models.images.CatImagesResponse
import com.jacob.thecatapi.data.utils.Configurations
import com.jacob.thecatapi.domain.useCases.GetCatApiUseCase
import com.jacob.thecatapi.presentation.core.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CatDetailsViewModel(
    private val getCatApiUseCase: GetCatApiUseCase
) : BaseViewModel(){

    var catImagesResponseMDL = MutableLiveData<CatImagesResponse>()
    var catImagesResponse: CatImagesResponse? = null

    init {
        getcatImages()
    }

    private fun getcatImages() {
        job = CoroutineScope(Dispatchers.IO).launch {
            catImagesResponse= getCatApiUseCase.invokeImages(
                apikey = Configurations.CATS_API_KEY
            ).body()
            withContext(Dispatchers.Main){
                catImagesResponse?.let {
                    catImagesResponseMDL.postValue(
                        it
                    )
                }
            }
        }
    }

}