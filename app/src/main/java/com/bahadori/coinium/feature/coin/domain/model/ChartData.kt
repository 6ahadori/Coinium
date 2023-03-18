package com.bahadori.coinium.feature.coin.domain.model


import com.google.gson.annotations.SerializedName

data class ChartData(
    @SerializedName("market_caps")
    val marketCaps: List<List<Double?>?>?,
    @SerializedName("prices")
    val prices: List<List<Double?>?>?,
    @SerializedName("total_volumes")
    val totalVolumes: List<List<Double?>?>?
)