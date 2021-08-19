package com.jacob.thecatapi.presentation.core.callBack

import com.jacob.thecatapi.data.network.models.breeds.TheCatApiResponseItem
import com.jacob.thecatapi.data.network.models.images.CatImagesResponseItem

interface OnItemClickListener<T> {

    fun onItemClick(item: TheCatApiResponseItem, type: String? = null)
}