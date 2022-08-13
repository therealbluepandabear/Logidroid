package com.therealbluepandabear.logidroid.models

/**
 * The logical XOR returns true when only one of its inputs are true
 *
 * Truth table:
 *
 * - `0` XOR `0` = `0`
 * - `0` XOR `1` = `1`
 * - `1` XOR `0` = `1`
 * - `1` XOR `1` = `0`
 */

class LogicalXOR : LogicGate() {
    override val name: String
        get() = "Logical XOR"

    override val function: (Boolean, Boolean) -> Boolean
        get() = { b1, b2 -> b1 xor b2 }
}