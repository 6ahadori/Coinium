package com.bahadori.coinium.feature.list.data.dto.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("error")
    val error: String?
)

