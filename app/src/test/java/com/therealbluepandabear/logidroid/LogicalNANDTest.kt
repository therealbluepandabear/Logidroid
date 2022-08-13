package com.therealbluepandabear.logidroid

import com.therealbluepandabear.logidroid.models.LogicGate
import com.therealbluepandabear.logidroid.models.LogicalNAND
import org.junit.Test

class LogicalNANDTest {
    @Test
    fun logicalNAND_test_1() {
        val logicalNAND: LogicGate = LogicalNAND()
        assert(!logicalNAND.performOperation(b1 = true, b2 = true))
    }

    @Test
    fun logicalNAND_test_2() {
        val logicalNAND: LogicGate = LogicalNAND()
        assert(logicalNAND.performOperation(b1 = false, b2 = false))
    }

    @Test
    fun logicalNAND_test_3() {
        val logicalNAND: LogicGate = LogicalNAND()
        assert(logicalNAND.performOperation(b1 = true, b2 = false))
    }

    @Test
    fun logicalNAND_test_4() {
        val logicalNAND: LogicGate = LogicalNAND()
        assert(logicalNAND.performOperation(b1 = false, b2 = true))
    }
}