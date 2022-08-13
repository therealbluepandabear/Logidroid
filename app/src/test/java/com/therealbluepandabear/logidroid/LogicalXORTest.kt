package com.therealbluepandabear.logidroid

import com.therealbluepandabear.logidroid.models.LogicGate
import com.therealbluepandabear.logidroid.models.LogicalXOR
import org.junit.Test

class LogicalXORTest {
    @Test
    fun logicalXOR_test_1() {
        val logicalXOR: LogicGate = LogicalXOR()
        assert(!logicalXOR.performOperation(b1 = true, b2 = true))
    }

    @Test
    fun logicalXOR_test_2() {
        val logicalXOR: LogicGate = LogicalXOR()
        assert(!logicalXOR.performOperation(b1 = false, b2 = false))
    }

    @Test
    fun logicalXOR_test_3() {
        val logicalXOR: LogicGate = LogicalXOR()
        assert(logicalXOR.performOperation(b1 = true, b2 = false))
    }

    @Test
    fun logicalXOR_test_4() {
        val logicalXOR: LogicGate = LogicalXOR()
        assert(logicalXOR.performOperation(b1 = false, b2 = true))
    }
}