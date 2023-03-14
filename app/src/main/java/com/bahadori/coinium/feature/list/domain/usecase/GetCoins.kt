package com.bahadori.coinium.feature.list.domain.usecase

import com.bahadori.coinium.feature.core.data.remote.NetworkConstants.DEFAULT_SYMBOL
import com.bahadori.coinium.feature.core.data.remote.NetworkConstants.LOAD_COUNT
import com.bahadori.coinium.feature.core.data.remote.NetworkConstants.UNKNOWN_ERROR
import com.bahadori.coinium.feature.core.util.common.Resource
import com.bahadori.coinium.feature.list.domain.model.Coin
import com.bahadori.coinium.feature.list.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCoins(
    private val repository: CoinRepository
) {

    operator fun invoke(page: Int): Flow<Resource<List<Coin>>> = flow {

        try {
            emit(Resource.Loading())

            val coins = repository.getCoins(
                DEFAULT_SYMBOL,
                null,
                null,
                LOAD_COUNT,
                page,
                null,
                null
            )
            emit(Resource.Success(coins))

        } catch (e: Throwable) {
            emit(Resource.Error(e.message ?: UNKNOWN_ERROR))
        }

    }

}