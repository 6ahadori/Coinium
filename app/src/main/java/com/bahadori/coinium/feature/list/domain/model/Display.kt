package com.bahadori.coinium.feature.list.domain.model


import com.google.gson.annotations.SerializedName

data class Display(
    @SerializedName("USD")
    val usd: DisplayUSD?
)