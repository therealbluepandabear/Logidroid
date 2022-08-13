package com.therealbluepandabear.logidroid.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.therealbluepandabear.logidroid.extensions.setEasyBounds
import com.therealbluepandabear.logidroid.extensions.toBinaryInt

class BinaryInputView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {
    private val rect1 = Rect().apply {
        setEasyBounds(0,0, 100, 100)
    }

    private val filledPaint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.BLACK
    }

    private val textPaint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.WHITE
        textSize = 50f
        textAlign = Paint.Align.CENTER
    }

    private var binaryInput: Boolean = false

    fun setBinaryInput(binaryInput: Boolean) {
        this.binaryInput = binaryInput
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(rect1.width(), rect1.height())
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(rect1, filledPaint)
        canvas.drawText(binaryInput.toBinaryInt().toString(), rect1.exactCenterX(), rect1.exactCenterY() - ((textPaint.descent() + textPaint.ascent()) / 2), textPaint)
    }
}