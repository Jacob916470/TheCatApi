package com.jacob.thecatapi.presentation.core.callBack

interface ResultCallBack<T>{
    fun onSuccess(item: T)
    fun onError(message: String, type: T? = null)
}