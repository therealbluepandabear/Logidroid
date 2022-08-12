package com.therealbluepandabear.logidroid

import com.therealbluepandabear.logidroid.models.LogicGate
import com.therealbluepandabear.logidroid.models.LogicalOR
import org.junit.Test

class LogicalORTest {
    @Test
    fun logicalOR_test_1() {
        val logicalOR: LogicGate = LogicalOR()
        assert(logicalOR.performOperation(b1 = true, b2 = true))
    }

    @Test
    fun logicalOR_test_2() {
        val logicalOR: LogicGate = LogicalOR()
        assert(!logicalOR.performOperation(b1 = false, b2 = false))
    }

    @Test
    fun logicalOR_test_3() {
        val logicalOR: LogicGate = LogicalOR()
        assert(logicalOR.performOperation(b1 = true, b2 = false))
    }

    @Test
    fun logicalOR_test_4() {
        val logicalOR: LogicGate = LogicalOR()
        assert(logicalOR.performOperation(b1 = false, b2 = true))
    }
}