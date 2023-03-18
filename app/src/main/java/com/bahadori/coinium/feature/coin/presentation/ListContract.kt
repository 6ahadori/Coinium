package com.bahadori.coinium.feature.coin.presentation

import com.bahadori.coinium.feature.coin.domain.model.ChartData
import com.bahadori.coinium.feature.core.UnidirectionalViewModel
import com.bahadori.coinium.feature.core.util.common.LoadState
import com.bahadori.coinium.feature.coin.domain.model.Coin
import com.bahadori.coinium.feature.core.util.common.Resource

interface ListContract : UnidirectionalViewModel<ListContract.Event, ListContract.State> {

    data class State(
        val coins: List<Coin> = emptyList(),
        val page: Int = 1,
        val loading: LoadState = LoadState.Loading(false),
        val endReached: Boolean = false,
        val currentCoin: Coin? = null,
        val currentCoinChart: Resource<ChartData>? = null
    )

    sealed class Event {
        object LoadCoins : Event()
        object DoRefresh : Event()
        data class SetCurrentCoin(val coin: Coin) : Event()
        object GetChart : Event()
        object GetCoinData : Event()
        object OnBottomSheetDismissed : Event()
    }

}