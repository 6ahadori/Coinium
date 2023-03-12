package com.bahadori.coinium.feature.core.navigation

sealed class Destinations(val route: String) {
    object ListScreen : Destinations("list_screen")
    object DetailScreen : Destinations("detail_screen")
}