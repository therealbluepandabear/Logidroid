package com.therealbluepandabear.logidroid.models

class LogicalXOR : LogicGate() {
    override val name: String
        get() = "Logical XOR"

    override val function: (Boolean, Boolean) -> Boolean
        get() = { b1, b2 -> b1 xor b2 }
}