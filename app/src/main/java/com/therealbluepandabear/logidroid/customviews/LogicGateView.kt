package com.therealbluepandabear.logidroid.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.therealbluepandabear.logidroid.extensions.*
import com.therealbluepandabear.logidroid.models.LogicGate
import com.therealbluepandabear.logidroid.models.LogicalAND
import com.therealbluepandabear.logidroid.models.LogicalNOT
import com.therealbluepandabear.logidroid.models.UnaryGate

class LogicGateView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    private val rectThickness = 20

    private val inputARect = Rect().apply {
        setEasyBounds(50,50, 200, rectThickness)
    }

    private val inputBRect = Rect().apply {
        setEasyBounds(inputARect.left, inputARect.bottom + 100, inputARect.width(), inputARect.height())
    }

    private val computerRect = Rect().apply {
        setEasyBounds(inputARect.right - 50, 0, 200, inputBRect.bottom + 50)
    }

    private val inputAHitBoxRect = Rect().apply {
        setEasyBounds(0, inputARect.centerY() - 25, 50, 50)
    }

    private val inputBHitBoxRect = Rect().apply {
        setEasyBounds(0, inputBRect.centerY() - 25, 50, 50)
    }

    private val outputRect = Rect().apply {
        setEasyBounds(computerRect.right,computerRect.centerY() - rectThickness / 2, 200, rectThickness)
    }

    private val outputHitBoxRect = Rect().apply {
        setEasyBounds(outputRect.right,outputRect.centerY() - 50 / 2, 50, 50)
    }

    private val rectHitBoxPaint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.TRANSPARENT
    }

    private val filledPaint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.BLACK
    }

    private val labelTextPaint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.CYAN
        textSize = 25f
        textAlign = Paint.Align.CENTER
    }

    private val inputTextPaint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.BLACK
        textSize = 50f
        textAlign = Paint.Align.CENTER
    }

    private var isUnarySet: Boolean = false

    private var logicGate: LogicGate = LogicalAND()
    private var unaryGate: UnaryGate = LogicalNOT()

    private var inputA: Boolean = false
    private var inputB: Boolean = false

    fun setLogicGate(logicGate: LogicGate) {
        this.logicGate = logicGate
    }

    fun setLogicGate(unaryGate: UnaryGate) {
        isUnarySet = true
        this.unaryGate = unaryGate
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(computerRect.width() + inputARect.width() + outputRect.width() + outputHitBoxRect.width(), computerRect.height())
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(inputARect, filledPaint)
        canvas.drawRect(inputBRect, filledPaint)
        canvas.drawRect(computerRect, filledPaint)

        canvas.drawRect(inputAHitBoxRect, rectHitBoxPaint)
        canvas.drawRect(inputBHitBoxRect, rectHitBoxPaint)

        canvas.drawRect(outputRect, filledPaint)
        canvas.drawRect(outputHitBoxRect, rectHitBoxPaint)

        val name = if (isUnarySet) {
            unaryGate.name
        } else {
            logicGate.name
        }

        val output = if (isUnarySet) {
            unaryGate.performOperation(inputA)
        } else {
            logicGate.performOperation(inputA, inputB)
        }

        inputAHitBoxRect.drawCenteredText(canvas, inputA.toBinaryInt().toString(), inputTextPaint)
        inputBHitBoxRect.drawCenteredText(canvas, inputB.toBinaryInt().toString(), inputTextPaint)
        computerRect.drawCenteredText(canvas, name, labelTextPaint)
        outputHitBoxRect.drawCenteredText(canvas, output.toBinaryInt().toString(), inputTextPaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (inputAHitBoxRect.contains(event.x.toInt(), event.y.toInt())) {
                    inputA = !inputA
                    invalidate()
                } else if (inputBHitBoxRect.contains(event.x.toInt(), event.y.toInt())) {
                    inputB = !inputB
                    invalidate()
                }
            }
        }
        return true
    }
}