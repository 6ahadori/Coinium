package com.bahadori.coinium.feature.core.data.remote

import com.bahadori.coinium.feature.core.data.remote.Endpoints.CHART
import com.bahadori.coinium.feature.core.data.remote.Endpoints.COINS
import com.bahadori.coinium.feature.list.domain.model.ChartData
import com.bahadori.coinium.feature.list.domain.model.Coin
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CryptoApi {

    @GET(COINS)
    suspend fun getCoins(
        @Query("vs_currency") vsCurrency: String,
        @Query("ids") ids: String?,
        @Query("category") category: String?,
        @Query("per_page") perPage: Int?,
        @Query("page") page: Int?,
        @Query("sparkline") sparkline: Boolean?,
        @Query("price_change_percentage") priceChangePercentage: String?,
    ): Response<List<Coin>>

    @GET(CHART)
    suspend fun getChart(
        @Path("id") id: String,
        @Query("vs_currency") vsCurrency: String,
        @Query("days") days: String,
        @Query("interval") interval: String?,
    ): Response<ChartData>

}