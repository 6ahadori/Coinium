package com.bahadori.coinium.di

import com.bahadori.coinium.feature.core.data.remote.CryptoApi
import com.bahadori.coinium.feature.list.data.repository.CoinRepositoryImpl
import com.bahadori.coinium.feature.list.domain.repository.CoinRepository
import com.bahadori.coinium.feature.list.domain.usecase.CoinsUseCase
import com.bahadori.coinium.feature.list.domain.usecase.GetCoins
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
            getCoins = GetCoins(repository)
        )
    }
}