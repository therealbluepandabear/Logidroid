package com.therealbluepandabear.logidroid.models

class LogicalOR : LogicGate() {
    override val name: String
        get() = "Logical OR"

    override val function: (Boolean, Boolean) -> Boolean
        get() = { b1, b2 -> b1 or b2 }
}