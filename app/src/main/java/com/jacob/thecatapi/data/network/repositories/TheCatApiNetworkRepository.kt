package com.jacob.thecatapi.data.network.repositories

import com.jacob.thecatapi.data.network.NetworkModule
import com.jacob.thecatapi.data.network.models.TheCatApiResponse
import com.jacob.thecatapi.data.network.services.TheCatApiService
import com.jacob.thecatapi.data.utils.Configurations
import com.jacob.thecatapi.domain.repositories.GetApiRepository
import retrofit2.Response

class TheCatApiNetworkRepository: GetApiRepository {

    private val retrofitInstance =
        NetworkModule().provideRetrofit(baseURL = Configurations().getBaseURL())

    override suspend fun getCatsApiRepository(
        apykey: String
    ): Response<TheCatApiResponse> {
        return NetworkModule().provideApi(
            retrofit = retrofitInstance,
            service = TheCatApiService::class.java
        ).getApiCat(
            apikey = apykey
        )
    }
}