package com.jacob.thecatapi.domain.repositories

import com.jacob.thecatapi.data.network.models.breeds.TheCatApiResponse
import com.jacob.thecatapi.data.network.models.images.CatImagesResponse
import retrofit2.Response

interface GetApiRepository {

    suspend fun getCatsApiRepository(
        apykey: String
    ): Response<TheCatApiResponse>

    suspend fun getCatImagesRepository(
        apikey: String
    ):Response<CatImagesResponse>
}