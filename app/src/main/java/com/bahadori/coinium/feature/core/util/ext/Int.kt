package com.bahadori.coinium.feature.core.util.ext

import java.text.NumberFormat
import java.util.*

fun Int?.format(): String {
    if (this == null) return "0"
    return NumberFormat.getNumberInstance(Locale.US).format(this)
}