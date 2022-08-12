package com.therealbluepandabear.logidroid.models

abstract class UnaryGate {
    protected abstract val function: (Boolean) -> Boolean

    fun performOperation(b1: Boolean): Boolean {
        return function(b1)
    }
}