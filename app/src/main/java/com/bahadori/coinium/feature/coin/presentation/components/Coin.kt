@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.bahadori.coinium.feature.coin.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bahadori.coinium.feature.core.util.ext.format
import com.bahadori.coinium.feature.coin.domain.model.Coin
import com.bahadori.coinium.feature.coin.util.ext.GetPercentageChangeCompose
import com.bahadori.coinium.ui.theme.title


@Composable
fun Coin(
    coin: Coin,
    onCoinClicked: ((Coin) -> Unit)
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 6.dp),
        onClick = {
            onCoinClicked(coin)
        },
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(12.dp, 0.dp)
            ) {
                coin.marketCapRank?.let { rank ->
                    Text(
                        text = rank.format(), color = MaterialTheme.colorScheme.title,
                        modifier = Modifier.padding(4.dp, 0.dp)
                    )
                }
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(coin.image)
                        .build(),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(8.dp)
                        .clip(MaterialTheme.shapes.large),
                    contentDescription = "Logo"
                )
                Column() {
                    Text(
                        text = coin.name ?: "",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.title
                    )
                    Text(
                        text = coin.symbol?.uppercase() ?: "",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Column(modifier = Modifier.padding(18.dp, 0.dp), horizontalAlignment = Alignment.End) {
                Text(
                    text = "$${coin.currentPrice.format()}",
                    color = MaterialTheme.colorScheme.title
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    coin.GetPercentageChangeCompose()
                }
            }
        }
    }
}