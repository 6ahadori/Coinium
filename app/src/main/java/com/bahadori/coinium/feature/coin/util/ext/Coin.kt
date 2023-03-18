package com.bahadori.coinium.feature.coin.util.ext

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bahadori.coinium.R
import com.bahadori.coinium.feature.core.util.ext.roundTo
import com.bahadori.coinium.feature.coin.domain.model.Coin
import com.bahadori.coinium.ui.theme.green
import com.bahadori.coinium.ui.theme.red
import com.bahadori.coinium.ui.theme.reverseTitle
import com.bahadori.coinium.ui.theme.title

@Composable
fun Coin.GetPercentageChangeCompose() {
    val percent = priceChangePercentage24h
    if (percent == null) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "0%",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Light),
                color = MaterialTheme.colorScheme.title
            )
        }
    } else {
        if (percent > 0) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "+${percent.roundTo(1)}%",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Light
                    ),
                    color = MaterialTheme.colorScheme.green
                )
                Icon(
                    modifier = Modifier.size(12.dp),
                    painter = painterResource(id = R.drawable.arrow_up),
                    contentDescription = "Arrow",
                    tint = MaterialTheme.colorScheme.green
                )
            }
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "${percent.roundTo(1)}%",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Light),
                    color = MaterialTheme.colorScheme.red
                )
                Icon(
                    modifier = Modifier.size(12.dp),
                    painter = painterResource(id = R.drawable.arrow_down),
                    contentDescription = "Arrow",
                    tint = MaterialTheme.colorScheme.red
                )
            }
        }
    }
}

@Composable
fun Coin.GetBottomSheetPercentageChangeCompose() {
    val percent = priceChangePercentage24h
    if (percent == null) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "0%",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Light),
                color = MaterialTheme.colorScheme.title,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .background(MaterialTheme.colorScheme.reverseTitle)
                    .padding(4.dp, 0.dp)
            )
        }
    } else {
        if (percent > 0) {
            Text(
                text = "+${percent.roundTo(1)}%",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.Light
                ),
                color = Color.White,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .background(MaterialTheme.colorScheme.green)
                    .padding(4.dp, 0.dp)
            )

        } else {
            Text(
                text = "${percent.roundTo(1)}%",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Light),
                color = Color.White,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .background(MaterialTheme.colorScheme.red)
                    .padding(4.dp, 0.dp)
            )
        }
    }
}