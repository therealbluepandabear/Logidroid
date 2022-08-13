package com.therealbluepandabear.logidroid.extensions

fun Boolean.toBinaryInt(): Int {
    return if (this) {
        1
    } else {
        0
    }
}