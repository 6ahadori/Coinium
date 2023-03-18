package com.bahadori.coinium.feature.coin.domain.usecase

import com.bahadori.coinium.feature.core.data.remote.NetworkConstants.DEFAULT_SYMBOL
import com.bahadori.coinium.feature.core.data.remote.NetworkConstants.LOAD_COUNT
import com.bahadori.coinium.feature.coin.domain.model.Coin
import com.bahadori.coinium.feature.coin.domain.repository.CoinRepository
import kotlinx.coroutines.delay

class GetCoins(
    private val repository: CoinRepository
) {

    suspend operator fun invoke(page: Int): Result<List<Coin>> {

        return try {
            delay(3000) // Just for Api limitation that is 10 requests/seconds
            val response = repository.getCoins(
                DEFAULT_SYMBOL,
                null,
                null,
                LOAD_COUNT,
                page,
                null,
                null
            )
            Result.success(response)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}