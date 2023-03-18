package com.bahadori.coinium.di

import com.bahadori.coinium.feature.core.data.remote.CryptoApi
import com.bahadori.coinium.feature.coin.data.repository.CoinRepositoryImpl
import com.bahadori.coinium.feature.coin.domain.repository.CoinRepository
import com.bahadori.coinium.feature.coin.domain.usecase.CoinsUseCase
import com.bahadori.coinium.feature.coin.domain.usecase.GetChart
import com.bahadori.coinium.feature.coin.domain.usecase.GetCoin
import com.bahadori.coinium.feature.coin.domain.usecase.GetCoins
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoinModule {

    @Provides
    @Singleton
    fun provideCoinRepository(api: CryptoApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCoinUseCase(repository: CoinRepository): CoinsUseCase {
        return CoinsUseCase(
            getCoins = GetCoins(repository),
            getCoin = GetCoin(repository),
            getChart = GetChart(repository),
        )
    }
}