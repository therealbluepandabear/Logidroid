package com.therealbluepandabear.logidroid.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.therealbluepandabear.logidroid.extensions.getHeight
import com.therealbluepandabear.logidroid.extensions.getWidth
import com.therealbluepandabear.logidroid.extensions.setB1
import com.therealbluepandabear.logidroid.models.*

class LogicGateView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    private val rectThickness = 20

    private val rect1 = Rect().apply {
        setB1(0,50, 200, rectThickness)
    }

    private val rect2 = Rect().apply {
        setB1(rect1.left, rect1.bottom + 100, rect1.getWidth(), rect1.getHeight())
    }

    private val rect3 = Rect().apply {
        setB1(rect1.right, 0, 200, rect2.bottom + 50)
    }

    private val filledPaint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.BLACK
    }

    private val textPaint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.CYAN
        textSize = 25f
        textAlign = Paint.Align.CENTER
    }

    private var isUnarySet: Boolean = false

    private var logicGate: LogicGate = LogicalAND()
    private var unaryGate: UnaryGate = LogicalNOT()

    fun setLogicGate(logicGate: LogicGate) {
        this.logicGate = logicGate
    }

    fun setLogicGate(unaryGate: UnaryGate) {
        isUnarySet = true
        this.unaryGate = unaryGate
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(rect3.width() + rect1.width(), rect3.height())
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(rect1, filledPaint)
        canvas.drawRect(rect2, filledPaint)
        canvas.drawRect(rect3, filledPaint)

        val name = if (isUnarySet) {
            unaryGate.name
        } else {
            logicGate.name
        }

        canvas.drawText(name, rect3.exactCenterX(), rect3.exactCenterY() - ((textPaint.descent() + textPaint.ascent()) / 2), textPaint)
    }
}