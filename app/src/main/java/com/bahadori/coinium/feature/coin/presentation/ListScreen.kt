
package com.bahadori.coinium.feature.coin.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bahadori.coinium.R
import com.bahadori.coinium.feature.coin.domain.model.Coin
import com.bahadori.coinium.feature.coin.presentation.ListContract.Event
import com.bahadori.coinium.feature.coin.presentation.components.Coin
import com.bahadori.coinium.feature.coin.presentation.components.CoinBottomSheet
import com.bahadori.coinium.feature.core.base.BaseViewModel
import com.bahadori.coinium.feature.core.use
import com.bahadori.coinium.feature.core.util.common.LoadState
import com.bahadori.coinium.feature.core.util.ext.justLoading
import com.bahadori.coinium.feature.core.util.ext.refreshing
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun ListRoute(
    viewModel: ListViewModel = hiltViewModel(),
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {
    val (state, event) = use(viewModel = viewModel)

    LaunchedEffect(Unit) {
        onProvideBaseViewModel(viewModel)
        event(Event.LoadCoins)
    }

    ListScreen(
        state = state,
        onGetChart = {
            event(Event.GetChart)
        },
        onCoinClicked = { coin: Coin ->
            event(Event.SetCurrentCoin(coin))
        },
        onBottomSheetDismissed = {
            event(Event.OnBottomSheetDismissed)
        },
        onLoadCoins = {
            event(Event.LoadCoins)
        },
        onRefresh = {
            event(Event.DoRefresh)
        }
    )
}

@ExperimentalMaterial3Api
@ExperimentalMaterialApi
@Composable
private fun ListScreen(
    state: ListContract.State,
    onGetChart: () -> Unit,
    onCoinClicked: (Coin) -> Unit,
    onBottomSheetDismissed: () -> Unit,
    onLoadCoins: () -> Unit,
    onRefresh: () -> Unit,
) {
    val refreshState =
        rememberPullRefreshState(refreshing = state.loading.refreshing, onRefresh = onRefresh)
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val openBottomSheet = rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { it != SheetValue.PartiallyExpanded },
    )

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Icon(
                        modifier = Modifier.size(120.dp, 48.dp),
                        painter = painterResource(id = R.drawable.full_logo),
                        tint = MaterialTheme.colorScheme.onBackground,
                        contentDescription = "Logo"
                    )
                })
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .pullRefresh(refreshState)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.coins.size) { i ->
                    val coin = state.coins[i]
                    if (i >= state.coins.size - 1 && !state.endReached && !state.loading.justLoading) {
                        onLoadCoins()
                    }
                    Coin(coin = coin, onCoinClicked = { coin ->
                        scope.launch {
                            onCoinClicked(coin)
                            openBottomSheet.value = true
                        }
                    })
                }
                item {
                    if (state.loading.justLoading && state.coins.isNotEmpty()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(36.dp))
                        }
                    }
                }
            }
            PullRefreshIndicator(
                modifier = Modifier.align(Alignment.TopCenter),
                refreshing = state.loading.refreshing,
                state = refreshState
            )
            if (state.loading.justLoading && state.coins.isEmpty()) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(36.dp)
                )
            }
        }
    }

    if (openBottomSheet.value && state.currentCoin != null) {
        CoinBottomSheet(
            coin = state.currentCoin,
            chart = state.currentCoinChart,
            onGetChart = onGetChart,
            onDismiss = {
                openBottomSheet.value = false
                onBottomSheetDismissed()
            },
            sheetState = sheetState
        )
    }

    BackHandler(openBottomSheet.value) {
        openBottomSheet.value = false
        onBottomSheetDismissed()
    }

    if (state.loading is LoadState.Error) {
        val unknownError = stringResource(id = R.string.unexpected_error)
        LaunchedEffect(snackbarHostState) {
            snackbarHostState.showSnackbar(state.loading.message ?: unknownError)
        }
    }
}
