package com.bahadori.coinium.feature.list.data.repository

import com.bahadori.coinium.feature.core.data.remote.CryptoApi
import com.bahadori.coinium.feature.core.util.ext.message
import com.bahadori.coinium.feature.list.domain.model.ChartData
import com.bahadori.coinium.feature.list.domain.model.Coin
import com.bahadori.coinium.feature.list.domain.repository.CoinRepository

class CoinRepositoryImpl(
    private val api: CryptoApi
) : CoinRepository {

    override suspend fun getCoins(
        vsCurrency: String,
        ids: String?,
        category: String?,
        perPage: Int?,
        page: Int?,
        sparkline: Boolean?,
        priceChangePercentage: String?
    ): List<Coin> {
        val response = api.getCoins(
            vsCurrency, ids, category, perPage, page, sparkline, priceChangePercentage
        )
        if (response.isSuccessful && response.body() != null) {
            return response.body() ?: emptyList()
        } else {
            throw Exception(response.errorBody()?.message)
        }
    }

    override suspend fun getChart(
        id: String,
        vsCurrency: String,
        days: String,
        interval: String?
    ): ChartData? {
        val response = api.getChart(id, vsCurrency, days, interval)
        if (response.isSuccessful && response.body() != null) {
            return response.body()
        } else {
            throw Exception(response.errorBody()?.message)
        }
    }


}