package com.therealbluepandabear.logidroid

import com.therealbluepandabear.logidroid.models.LogicGate
import com.therealbluepandabear.logidroid.models.LogicalNOR
import org.junit.Test

class LogicalNORTest {
    @Test
    fun logicalNOR_test_1() {
        val logicalNOR: LogicGate = LogicalNOR()
        assert(!logicalNOR.performOperation(b1 = true, b2 = true))
    }

    @Test
    fun logicalNOR_test_2() {
        val logicalNOR: LogicGate = LogicalNOR()
        assert(logicalNOR.performOperation(b1 = false, b2 = false))
    }

    @Test
    fun logicalNOR_test_3() {
        val logicalNOR: LogicGate = LogicalNOR()
        assert(!logicalNOR.performOperation(b1 = true, b2 = false))
    }

    @Test
    fun logicalNOR_test_4() {
        val logicalNOR: LogicGate = LogicalNOR()
        assert(!logicalNOR.performOperation(b1 = false, b2 = true))
    }
}