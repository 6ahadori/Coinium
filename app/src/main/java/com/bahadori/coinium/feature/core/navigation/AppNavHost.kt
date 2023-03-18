package com.bahadori.coinium.feature.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bahadori.coinium.feature.core.base.BaseViewModel
import com.bahadori.coinium.feature.coin.presentation.ListRoute

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier,
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.ListScreen.route,
        modifier = modifier,
    ) {
        composable(Destinations.ListScreen.route) {
            ListRoute(
                onProvideBaseViewModel = {
                    onProvideBaseViewModel(it)
                }
            )
        }
    }
}