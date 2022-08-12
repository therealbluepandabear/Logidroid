package com.therealbluepandabear.logidroid.models

class LogicalNOR : LogicGate() {
    override val name: String
        get() = "Logical NOR"

    override val function: (Boolean, Boolean) -> Boolean
        get() = { b1, b2 -> !(b1 or b2) }
}