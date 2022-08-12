package com.therealbluepandabear.logidroid.models

class LogicalNOT : UnaryGate() {
    override val function: (Boolean) -> Boolean
        get() = { !it }
}