package com.therealbluepandabear.logidroid.models

class LogicalNOT : UnaryGate() {
    override val name: String
        get() = "Logical NOT"

    override val function: (Boolean) -> Boolean
        get() = { !it }
}