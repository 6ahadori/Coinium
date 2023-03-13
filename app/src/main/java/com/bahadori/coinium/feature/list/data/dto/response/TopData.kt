package com.bahadori.coinium.feature.list.data.dto.response


import com.bahadori.coinium.feature.list.domain.model.Data
import com.google.gson.annotations.SerializedName

data class TopData(
    @SerializedName("Data")
    val data: List<Data>?,
    @SerializedName("HasWarning")
    val hasWarning: Boolean?,
    @SerializedName("Message")
    val message: String?,
)