package com.bahadori.coinium.feature.core.util.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.bahadori.coinium.feature.core.base.BaseViewModel
import com.bahadori.coinium.feature.core.navigation.Destinations

@Composable
fun ComposeNewsNavHost(
    navController: NavHostController,
    modifier: Modifier,
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.ListScreen.route,
        modifier = modifier,
    ) {

    }
}