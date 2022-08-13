package com.therealbluepandabear.logidroid.extensions

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect

fun Rect.setEasyBounds(x: Int, y: Int, width: Int, height: Int) {
    left = x
    top = y
    right = width + left
    bottom = height + top
}

fun Rect.drawCenteredText(canvas: Canvas, text: String, paint: Paint) {
    canvas.drawText(text, exactCenterX(), exactCenterY() - ((paint.descent() + paint.ascent()) / 2), paint)
}