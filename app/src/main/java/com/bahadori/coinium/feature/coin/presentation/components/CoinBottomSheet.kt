@file:OptIn(ExperimentalMaterial3Api::class)

package com.bahadori.coinium.feature.coin.presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bahadori.coinium.feature.coin.domain.model.ChartData
import com.bahadori.coinium.feature.coin.domain.model.Coin
import com.bahadori.coinium.feature.coin.util.ext.GetBottomSheetPercentageChangeCompose
import com.bahadori.coinium.feature.core.util.common.Resource
import com.bahadori.coinium.feature.core.util.ext.format
import com.bahadori.coinium.feature.core.util.ext.toPair
import com.bahadori.coinium.ui.theme.title
import com.bahadori.coinium.R
import kotlinx.coroutines.launch


@Composable
fun CoinBottomSheet(
    coin: Coin,
    chart: Resource<ChartData>?,
    onGetChart: () -> Unit,
    onDismiss: () -> Unit,
    sheetState: SheetState,
) {

    LaunchedEffect(coin.id) {
        coin.id?.let { onGetChart() }
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier.align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(coin.image)
                            .build(),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(18.dp)
                            .clip(MaterialTheme.shapes.large),
                        contentDescription = "Logo"
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = coin.name ?: "",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium),
                        color = MaterialTheme.colorScheme.title
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "$${coin.currentPrice.format()}",
                        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Black),
                        color = MaterialTheme.colorScheme.title
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    coin.GetBottomSheetPercentageChangeCompose()
                }
            }

            when (chart) {
                is Resource.Error -> {
                    Text(
                        text = chart.message ?: stringResource(id = R.string.unexpected_error),
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.title,
                        textAlign = TextAlign.Center
                    )
                }
                is Resource.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(24.dp)
                    )
                }
                is Resource.Success -> {
                    chart.data?.prices?.mapNotNull { it?.toPair() }?.let { models ->
                        StockChart(
                            info = models as List<Pair<Double, Double>>,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp)
                                .height(300.dp)
                                .align(Alignment.BottomCenter)
                        )
                    }
                }
                null -> Unit
            }
        }
    }
}