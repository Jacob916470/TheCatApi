package com.jacob.thecatapi.data.network.services

import com.jacob.thecatapi.data.network.models.breeds.TheCatApiResponse
import com.jacob.thecatapi.data.network.models.images.CatImagesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCatApiService {

    @GET(value = "breeds")
    suspend fun getApiCat(
        @Query(value = "apikey")
        apikey: String
    ): Response<TheCatApiResponse>

    @GET(value = "images/search?mime_types=gif,jpg,png")
    suspend fun getCatImages(
        @Query(value = "apikey")
        apikey: String
    ): Response<CatImagesResponse>
}