package com.therealbluepandabear.logidroid.models

class LogicalXNOR : LogicGate() {
    override val function: (Boolean, Boolean) -> Boolean
        get() = { b1, b2 -> ((b1 && b2) || (!b1 && !b2)) }
}