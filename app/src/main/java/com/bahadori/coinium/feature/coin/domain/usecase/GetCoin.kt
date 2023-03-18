package com.bahadori.coinium.feature.coin.domain.usecase

import com.bahadori.coinium.feature.core.data.remote.NetworkConstants.DEFAULT_SYMBOL
import com.bahadori.coinium.feature.core.data.remote.NetworkConstants.LOAD_COUNT
import com.bahadori.coinium.feature.coin.domain.model.Coin
import com.bahadori.coinium.feature.coin.domain.repository.CoinRepository
import kotlinx.coroutines.delay

class GetCoin(
    private val repository: CoinRepository
) {

    suspend operator fun invoke(id: String): Result<Coin?> {

        return try {
            delay(3000) // Just for Api limitation that is 10 requests/seconds
            val response = repository.getCoins(
                DEFAULT_SYMBOL,
                id,
                null,
                null,
                null,
                null,
                null
            )
            Result.success(response.getOrNull(0))
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}