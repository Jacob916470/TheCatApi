package com.jacob.thecatapi.domain.useCases

import com.jacob.thecatapi.data.network.models.breeds.TheCatApiResponse
import com.jacob.thecatapi.data.network.models.images.CatImagesResponse
import com.jacob.thecatapi.domain.repositories.GetApiRepository
import retrofit2.Response

class GetCatApiUseCase(
    private val getApiRepository: GetApiRepository
) {
    suspend fun invoke(
        apikey: String
    ): Response<TheCatApiResponse> {
        return getApiRepository.getCatsApiRepository(
            apykey = apikey
        )
    }

    suspend fun invokeImages(
        apikey: String
    ): Response<CatImagesResponse>{
        return getApiRepository.getCatImagesRepository(
            apikey = apikey
        )
    }
}