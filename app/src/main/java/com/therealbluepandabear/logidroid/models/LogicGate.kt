package com.therealbluepandabear.logidroid.models

abstract class LogicGate {
    abstract val name: String
    protected abstract val function: (Boolean, Boolean) -> Boolean

    fun performOperation(b1: Boolean, b2: Boolean): Boolean {
        return function(b1, b2)
    }
}