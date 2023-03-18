package com.bahadori.coinium.feature.coin.domain.usecase

import com.bahadori.coinium.feature.core.data.remote.NetworkConstants.DEFAULT_SYMBOL
import com.bahadori.coinium.feature.core.data.remote.NetworkConstants.UNKNOWN_ERROR
import com.bahadori.coinium.feature.core.util.common.Resource
import com.bahadori.coinium.feature.coin.domain.model.ChartData
import com.bahadori.coinium.feature.coin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetChart(
    private val repository: CoinRepository
) {

    operator fun invoke(id: String?, days: String?, interval: String?): Flow<Resource<ChartData>> =
        flow {

            try {
                if (id == null) throw NullPointerException("Invalid CoinId.")
                if (days == null) throw NullPointerException("Invalid days.")
                emit(Resource.Loading())

                val chartData = repository.getChart(
                    id,
                    DEFAULT_SYMBOL,
                    days,
                    interval,
                ) ?: throw NullPointerException()
                emit(Resource.Success(chartData))

            } catch (e: Throwable) {
                emit(Resource.Error(e.message ?: UNKNOWN_ERROR))
            }

        }

}