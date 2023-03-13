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

        emit(Resource.Loading())

        val result = repository.getTopCoins(LOAD_COUNT, DEFAULT_SYMBOL, page)
        val coins = result.getOrNull()

        if (result.isSuccess && coins != null) {
            emit(Resource.Success(coins))
        } else {
            emit(Resource.Error(result.exceptionOrNull()?.message ?: UNKNOWN_ERROR))
        }

    }

}