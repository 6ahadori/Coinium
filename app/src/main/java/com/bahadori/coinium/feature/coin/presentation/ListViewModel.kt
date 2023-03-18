package com.bahadori.coinium.feature.coin.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.bahadori.coinium.feature.core.base.BaseViewModel
import com.bahadori.coinium.feature.core.util.common.Constants.TAG
import com.bahadori.coinium.feature.core.util.common.LoadState
import com.bahadori.coinium.feature.core.util.paginator.DefaultPaginator
import com.bahadori.coinium.feature.coin.domain.usecase.CoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val coinsUseCase: CoinsUseCase
) : BaseViewModel(), ListContract {

    private val _state = MutableStateFlow(ListContract.State())
    override val state: StateFlow<ListContract.State> = _state.asStateFlow()

    private var coinJob: Job? = null
    private var coinChartJob: Job? = null

    private val paginator = DefaultPaginator(
        initialKey = state.value.page,
        onLoadUpdated = { loading ->
            if (loading)
                _state.update {
                    it.copy(loading = LoadState.Loading())
                }
        },
        onRequest = { nextPage ->
            coinsUseCase.getCoins(nextPage)
        },
        getNextKey = {
            state.value.page + 1
        },
        onError = { e ->
            _state.update {
                it.copy(loading = LoadState.Error(e?.message))
            }
        },
        onSuccess = { list, newPage, start ->
            Log.i(TAG, "newPage:$newPage start:$start ")
            _state.update {
                it.copy(
                    loading = LoadState.NotLoading(),
                    endReached = list.isEmpty(),
                    coins = if (start) list else (state.value.coins + list),
                    page = newPage
                )
            }
        }
    )

    init {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }

    override fun event(event: ListContract.Event) {
        when (event) {
            is ListContract.Event.DoRefresh -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(loading = (LoadState.Loading(true)))
                    paginator.reset()
                    paginator.loadNextItems()
                }
            }
            is ListContract.Event.LoadCoins -> {
                viewModelScope.launch {
                    paginator.loadNextItems()
                }
            }
            is ListContract.Event.SetCurrentCoin -> {
                _state.update {
                    it.copy(currentCoin = event.coin)
                }
                getCoinData()
            }
            ListContract.Event.GetChart -> {
                getChart()
            }
            ListContract.Event.GetCoinData -> {
                getCoinData()
            }
            ListContract.Event.OnBottomSheetDismissed -> {
                coinJob?.cancel()
                coinChartJob?.cancel()
            }
        }
    }

    private fun getChart() {
        coinChartJob?.cancel()
        coinChartJob = viewModelScope.launch {
            while (true) {
                state.value.currentCoin?.id?.let { id ->
                    coinsUseCase.getChart(id, "1d", "1m").onEach { resource ->
                        _state.update {
                            it.copy(currentCoinChart = resource)
                        }
                    }.launchIn(viewModelScope)
                }
                delay(INTERVALS)
            }
        }
    }


    private fun getCoinData() {
        coinJob?.cancel()
        coinJob = viewModelScope.launch {
            while (true) {
                state.value.currentCoin?.id?.let { id ->
                    val result = coinsUseCase.getCoin(id).getOrDefault(state.value.currentCoin)
                    _state.update {
                        it.copy(currentCoin = result)
                    }
                }
                delay(INTERVALS)
            }
        }
    }

    companion object {
        private const val INTERVALS: Long = 20_000
    }
}