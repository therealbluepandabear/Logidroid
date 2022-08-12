package com.therealbluepandabear.logidroid.models

class LogicalXNOR : LogicGate() {
    override val name: String
        get() = "Logical XNOR"

    override val function: (Boolean, Boolean) -> Boolean
        get() = { b1, b2 -> ((b1 && b2) || (!b1 && !b2)) }
}