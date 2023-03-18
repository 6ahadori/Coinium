package com.bahadori.coinium.feature.core.util.ext

import com.bahadori.coinium.feature.core.util.common.LoadState

inline val LoadState.refreshing: Boolean get() = this is LoadState.Loading && refresh

inline val LoadState.justLoading: Boolean get() = this is LoadState.Loading && !refresh
