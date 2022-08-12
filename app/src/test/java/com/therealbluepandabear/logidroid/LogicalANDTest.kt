package com.therealbluepandabear.logidroid

import com.therealbluepandabear.logidroid.models.LogicGate
import com.therealbluepandabear.logidroid.models.LogicalAND
import org.junit.Test

class LogicalANDTest {
    @Test
    fun logicalAND_test_1() {
        val logicalAND: LogicGate = LogicalAND()
        assert(logicalAND.performOperation(b1 = true, b2 = true))
    }

    @Test
    fun logicalAND_test_2() {
        val logicalAND: LogicGate = LogicalAND()
        assert(!logicalAND.performOperation(b1 = false, b2 = false))
    }

    @Test
    fun logicalAND_test_3() {
        val logicalAND: LogicGate = LogicalAND()
        assert(!logicalAND.performOperation(b1 = true, b2 = false))
    }

    @Test
    fun logicalAND_test_4() {
        val logicalAND: LogicGate = LogicalAND()
        assert(!logicalAND.performOperation(b1 = false, b2 = true))
    }
}