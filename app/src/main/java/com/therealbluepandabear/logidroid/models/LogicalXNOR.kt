package com.therealbluepandabear.logidroid.models

/**
 * The logical XNOR returns true when both of its inputs are true or both of its inputs are false
 *
 * Truth table:
 *
 * - `0` OR `0` = `1`
 * - `0` OR `1` = `0`
 * - `1` OR `0` = `0`
 * - `1` OR `1` = `1`
 */

class LogicalXNOR : LogicGate() {
    override val name: String
        get() = "Logical XNOR"

    override val function: (Boolean, Boolean) -> Boolean
        get() = { b1, b2 -> ((b1 && b2) || (!b1 && !b2)) }
}