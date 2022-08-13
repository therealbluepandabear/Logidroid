package com.therealbluepandabear.logidroid.models

/**
 * The logical AND returns true only when both of its inputs are true
 *
 * Truth table:
 *
 * - `0` AND `0` = `0`
 * - `0` AND `1` = `0`
 * - `1` AND `0` = `0`
 * - `1` AND `1` = `1`
 */

class LogicalAND : LogicGate() {
    override val name: String
        get() = "Logical AND"

    override val function: (Boolean, Boolean) -> Boolean
        get() = { b1, b2 -> b1 and b2 }
}