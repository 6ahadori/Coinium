package com.bahadori.coinium.feature.list.domain.model


import com.google.gson.annotations.SerializedName

data class Raw(
    @SerializedName("USD")
    val usd: RawUSD?
)