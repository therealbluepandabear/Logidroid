package com.therealbluepandabear.logidroid.extensions

import android.graphics.Rect

fun Rect.setEasyBounds(x: Int, y: Int, width: Int, height: Int) {
    left = x
    top = y
    right = width + left
    bottom = height + top
}

fun Rect.getWidth(): Int {
    return right - left
}

fun Rect.getHeight(): Int {
    return bottom - top
}