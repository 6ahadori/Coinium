@file:OptIn(ExperimentalMaterialApi::class)

package com.bahadori.coinium.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bahadori.coinium.feature.core.base.BaseViewModel
import com.bahadori.coinium.feature.core.navigation.AppNavHost
import com.bahadori.coinium.feature.coin.domain.usecase.CoinsUseCase
import com.bahadori.coinium.ui.theme.CoiniumTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var coinsUseCase: CoinsUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoiniumTheme {
                var baseViewModel: BaseViewModel by remember {
                    mutableStateOf(BaseViewModel())
                }
                val navController = rememberNavController()
                val backStackEntry = navController.currentBackStackEntryAsState()
                val currentScreenRoute = backStackEntry.value?.destination?.route

                AppNavHost(
                    navController = navController,
                    modifier = Modifier,
                    onProvideBaseViewModel = { viewModel ->
                        baseViewModel = viewModel
                    }
                )
            }
        }
    }
}
