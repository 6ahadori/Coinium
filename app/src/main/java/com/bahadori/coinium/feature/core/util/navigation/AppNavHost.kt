package com.bahadori.coinium.feature.core.util.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = Destination.ListScreen.route,
        modifier = modifier,
    ) {
        listGraph()
        profileGraph(navController)
    }
}