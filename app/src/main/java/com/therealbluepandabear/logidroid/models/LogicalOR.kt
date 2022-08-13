package com.therealbluepandabear.logidroid.models

/**
 * The logical OR returns true when one or more of its inputs are true
 *
 * Truth table:
 *
 * - `0` OR `0` = `0`
 * - `0` OR `1` = `1`
 * - `1` OR `0` = `1`
 * - `1` OR `1` = `1`
 */

class LogicalOR : LogicGate() {
    override val name: String
        get() = "Logical OR"

    override val function: (Boolean, Boolean) -> Boolean
        get() = { b1, b2 -> b1 or b2 }
}