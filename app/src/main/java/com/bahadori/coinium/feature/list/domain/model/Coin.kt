package com.bahadori.coinium.feature.list.domain.model


import com.google.gson.annotations.SerializedName

data class Coin(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfo?,
    @SerializedName("DISPLAY")
    val display: Display?,
    @SerializedName("RAW")
    val raw: Raw?
)