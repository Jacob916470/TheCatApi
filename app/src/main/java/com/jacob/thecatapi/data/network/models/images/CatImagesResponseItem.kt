package com.jacob.thecatapi.data.network.models.images

data class CatImagesResponseItem(
    val breeds: List<Any>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)