package com.bahadori.coinium.feature.core.data.remote

import com.bahadori.coinium.feature.core.data.remote.Endpoints.TOP_DATA
import com.bahadori.coinium.feature.list.data.dto.response.TopData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {

    @GET(TOP_DATA)
    suspend fun getTopData(
        @Query("limit") limit: Int?,
        @Query("page") page: Int?,
        @Query("tsym") toSymbol: String,
        @Query("ascending") ascending: Boolean?,
        @Query("sign") sign: Boolean?,
    ): TopData

}