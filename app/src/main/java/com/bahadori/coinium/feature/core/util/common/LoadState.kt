package com.bahadori.coinium.feature.core.util.common


sealed class LoadState {
    data class Loading(val refresh: Boolean = false) : LoadState()
    data class NotLoading(val nothing: Unit = Unit) : LoadState()
    data class Error(val message: String? = null) : LoadState() {
        override fun equals(other: Any?): Boolean {
            return false
        }

        override fun hashCode(): Int {
            return message?.hashCode() ?: 0
        }
    }

    sealed class Type {
        object Append : Type()
        object Prepared : Type()
        object Refresh : Type()
    }
}