package com.bahadori.coinium.feature.list.domain.model


import com.google.gson.annotations.SerializedName

data class DisplayUSD(
    @SerializedName("FROMSYMBOL")
    val fromSymbol: String?,
    @SerializedName("TOSYMBOL")
    val toSymbol: String?,
    @SerializedName("IMAGEURL")
    val imageUrl: String?,
    @SerializedName("LASTMARKET")
    val lastMarket: String?,
    @SerializedName("PRICE")
    val price: String?,
)