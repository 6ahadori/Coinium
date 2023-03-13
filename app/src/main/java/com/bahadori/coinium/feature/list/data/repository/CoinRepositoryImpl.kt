package com.bahadori.coinium.feature.list.data.repository

import com.bahadori.coinium.feature.core.data.remote.CryptoApi
import com.bahadori.coinium.feature.list.domain.model.Coin
import com.bahadori.coinium.feature.list.domain.repository.CoinRepository

class CoinRepositoryImpl(
    private val api: CryptoApi
) : CoinRepository {


    override suspend fun getTopCoins(
        limit: Int?,
        toSymbol: String,
        page: Int?,
        ascending: Boolean?,
        sign: Boolean?
    ): Result<List<Coin>> {
        val topData = api.getTopData(limit, page, toSymbol, ascending, sign)
        return if (topData.data?.isNotEmpty() == true) {
            Result.success(topData.data)
        }else {
            Result.failure(Exception())
        }
    }


}