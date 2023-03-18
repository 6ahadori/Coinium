package com.bahadori.coinium.feature.core.util.paginator

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}