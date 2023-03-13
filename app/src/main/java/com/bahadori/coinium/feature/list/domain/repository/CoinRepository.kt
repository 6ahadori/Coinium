package com.bahadori.coinium.feature.list.domain.repository

import com.bahadori.coinium.feature.list.domain.model.Coin

interface CoinRepository {

    suspend fun getTopCoins(
        limit: Int?,
        toSymbol: String,
        page: Int? = null,
        ascending: Boolean? = true,
        sign: Boolean? = null,
    ): Result<List<Coin>>
}