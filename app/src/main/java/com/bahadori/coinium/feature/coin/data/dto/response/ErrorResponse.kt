package com.bahadori.coinium.feature.coin.data.dto.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("error")
    val error: String?
)

