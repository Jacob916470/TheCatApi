package com.jacob.thecatapi.data.network.services

import com.jacob.thecatapi.data.network.models.TheCatApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCatApiService {

    @GET(value = "breeds")
    suspend fun getApiCat(
        @Query(value = "apikey")
        apikey: String
    ): Response<TheCatApiResponse>
}