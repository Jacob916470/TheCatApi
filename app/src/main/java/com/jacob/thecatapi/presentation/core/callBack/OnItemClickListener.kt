package com.jacob.thecatapi.presentation.core.callBack

import com.jacob.thecatapi.data.network.models.TheCatApiResponseItem

interface OnItemClickListener<T> {

    fun onItemClick(item: TheCatApiResponseItem, type: String? = null)
}