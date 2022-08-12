package com.therealbluepandabear.logidroid.models

class LogicalNAND : LogicGate() {
    override val name: String
        get() = "Logical NAND"

    override val function: (Boolean, Boolean) -> Boolean
        get() = { b1, b2 -> !(b1 and b2) }
}