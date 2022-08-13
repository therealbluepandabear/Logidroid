package com.therealbluepandabear.logidroid.models

/**
 * The logical NOR returns true only when both of its inputs are false
 *
 * Truth table:
 *
 * - `0` NOR `0` = `1`
 * - `0` NOR `1` = `0`
 * - `1` NOR `0` = `0`
 * - `1` NOR `1` = `0`
 */

class LogicalNOR : LogicGate() {
    override val name: String
        get() = "Logical NOR"

    override val function: (Boolean, Boolean) -> Boolean
        get() = { b1, b2 -> !(b1 or b2) }
}