package com.bahadori.coinium.feature.core.components
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bahadori.coinium.feature.core.preview.ThemePreviews
import com.bahadori.coinium.ui.theme.CoiniumTheme

@Composable
fun LoadingView(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .height(34.dp)
                .width(34.dp)
                .align(Alignment.Center)
        )
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ThemePreviews
@Composable
private fun LoadingViewPreview() {
    CoiniumTheme {
        Scaffold {
            LoadingView()
        }
    }
}