package com.jacob.thecatapi.domain.repositories

import com.jacob.thecatapi.data.network.models.TheCatApiResponse
import retrofit2.Response

interface GetApiRepository {

    suspend fun getCatsApiRepository(
        apykey: String
    ): Response<TheCatApiResponse>
}