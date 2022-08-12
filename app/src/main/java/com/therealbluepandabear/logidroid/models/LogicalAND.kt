package com.therealbluepandabear.logidroid.models

class LogicalAND : LogicGate() {
    override val name: String
        get() = "Logical AND"

    override val function: (Boolean, Boolean) -> Boolean
        get() = { b1, b2 -> b1 and b2 }
}