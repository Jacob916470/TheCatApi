package com.jacob.thecatapi.data.utils

class Configurations {

    companion object {
        const val CATS_API_KEY = "fc7a0ab7-ba93-47f3-8908-112dfff67823"
    }

    private val currentConfiguration = "dev"

    private val configuration = mapOf(
        "dev" to Configuration(
            baseURL = "https://api.thecatapi.com/v1/"
        ),
        "qa" to Configuration(
            baseURL = "https://api.thecatapi.com/v1/"
        ),
        "release" to Configuration(
            baseURL = "https://api.thecatapi.com/v1/"
        )
    )

    private var baseURL: String = ""

    init {
        val setCOnfig = configuration[currentConfiguration]
        setCOnfig?.baseURL?.let { baseURL = it }
    }

    fun getBaseURL(): String = baseURL

    private data class Configuration(
        val baseURL: String = ""
    )
}