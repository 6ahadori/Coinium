package com.bahadori.coinium.feature.core.util.ext

import java.util.*

fun Double.roundTo(n: Int): Double {
    return "%.${n}f".format(this).toDouble()
}

fun Double?.format(): String {
    if (this == null) return "0.0"
    return if (this in 0.0..1.0)
        "%,.6f".format(Locale.ENGLISH, this)
    else "%,.2f".format(Locale.ENGLISH, this)
}