package com.jacob.thecatapi.presentation.core.callBack

import com.jacob.thecatapi.data.network.models.TheCatApiResponseItem

interface ResultCallBack<T>{
    fun onSuccess(item: T)
    fun onError(message: String, type: T? = null)
}