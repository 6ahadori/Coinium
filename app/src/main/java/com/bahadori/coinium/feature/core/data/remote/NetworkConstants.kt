package com.bahadori.coinium.feature.core.data.remote

object NetworkConstants {
    private const val V3 = "v3"
    const val BASE_URL = "https://api.coingecko.com/api/$V3/"
    const val RETRY = 3
    const val TIMEOUT: Long = 30
    const val UNKNOWN_ERROR = "An unexpected error occurred"
    const val LOAD_COUNT = 100
    const val DEFAULT_SYMBOL = "USD"
}