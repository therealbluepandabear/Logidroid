package com.therealbluepandabear.logidroid.models

/**
 * The logical NAND returns false only when both of its inputs are true
 *
 * Truth table:
 *
 * - `0` NAND `0` = `1`
 * - `0` NAND `1` = `1`
 * - `1` NAND `0` = `1`
 * - `1` NAND `1` = `0`
 */

class LogicalNAND : LogicGate() {
    override val name: String
        get() = "Logical NAND"

    override val function: (Boolean, Boolean) -> Boolean
        get() = { b1, b2 -> !(b1 and b2) }
}