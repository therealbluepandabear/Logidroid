package com.therealbluepandabear.logidroid.models

/**
 * The logical NOT is an inverter -- it returns true when its input is false, and false when its input is true
 *
 * Truth table:
 *
 * - NOT `0` = `1`
 * - NOT `1` = `0`
 */

class LogicalNOT : UnaryGate() {
    override val name: String
        get() = "Logical NOT"

    override val function: (Boolean) -> Boolean
        get() = { !it }
}