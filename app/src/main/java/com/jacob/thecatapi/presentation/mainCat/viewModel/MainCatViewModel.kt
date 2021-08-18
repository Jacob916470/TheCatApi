package com.jacob.thecatapi.presentation.mainCat.viewModel

import androidx.lifecycle.MutableLiveData
import com.jacob.thecatapi.data.network.models.TheCatApiResponse
import com.jacob.thecatapi.data.network.models.TheCatApiResponseItem
import com.jacob.thecatapi.data.utils.Configurations
import com.jacob.thecatapi.domain.useCases.GetCatApiUseCase
import com.jacob.thecatapi.presentation.core.base.BaseViewModel
import com.jacob.thecatapi.presentation.core.callBack.ResultCallBack
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainCatViewModel(
  private val getCatApiUseCase: GetCatApiUseCase,
  private val resultCallBack: ResultCallBack<TheCatApiResponseItem>
) : BaseViewModel(){

    var catsApiResponseMDL = MutableLiveData<TheCatApiResponse>()
    var catsApiResponse: TheCatApiResponse? = null

    init {
        getCatsApi()
    }

    private fun getCatsApi() {
        job = CoroutineScope(Dispatchers.IO).launch {
            catsApiResponse = getCatApiUseCase.invoke(
                apikey = Configurations.CATS_API_KEY
            ).body()
            withContext(Dispatchers.Main){
                catsApiResponse?.let {
                    catsApiResponseMDL.postValue(
                        it
                    )
                }
            }
        }
    }
}