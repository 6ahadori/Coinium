package com.bahadori.coinium.feature.core.util.ext

import com.bahadori.coinium.feature.core.data.remote.NetworkConstants.UNKNOWN_ERROR
import com.bahadori.coinium.feature.coin.data.dto.response.ErrorResponse
import com.google.gson.Gson
import okhttp3.ResponseBody


inline val ResponseBody.message: String
    get() {
        val errorResponse = Gson().fromJson(this.string(), ErrorResponse::class.java)
        return errorResponse.error ?: UNKNOWN_ERROR
    }