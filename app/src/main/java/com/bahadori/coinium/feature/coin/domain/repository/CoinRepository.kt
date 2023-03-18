package com.bahadori.coinium.feature.coin.domain.repository

import com.bahadori.coinium.feature.coin.domain.model.ChartData
import com.bahadori.coinium.feature.coin.domain.model.Coin

interface CoinRepository {

    suspend fun getCoins(
        vsCurrency: String,
        ids: String?,
        category: String?,
        perPage: Int?,
        page: Int?,
        sparkline: Boolean?,
        priceChangePercentage: String?,
    ): List<Coin>

    suspend fun getChart(
        id: String,
        vsCurrency: String,
        days: String,
        interval: String?,
    ): ChartData?
}