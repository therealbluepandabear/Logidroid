package com.therealbluepandabear.logidroid

import com.therealbluepandabear.logidroid.models.LogicGate
import com.therealbluepandabear.logidroid.models.LogicalXNOR
import org.junit.Test

class LogicalXNORTest {
    @Test
    fun logicalXNOR_test_1() {
        val logicalXNOR: LogicGate = LogicalXNOR()
        assert(logicalXNOR.performOperation(b1 = true, b2 = true))
    }

    @Test
    fun logicalXNOR_test_2() {
        val logicalXNOR: LogicGate = LogicalXNOR()
        assert(logicalXNOR.performOperation(b1 = false, b2 = false))
    }

    @Test
    fun logicalXNOR_test_3() {
        val logicalXNOR: LogicGate = LogicalXNOR()
        assert(!logicalXNOR.performOperation(b1 = true, b2 = false))
    }

    @Test
    fun logicalXNOR_test_4() {
        val logicalXNOR: LogicGate = LogicalXNOR()
        assert(!logicalXNOR.performOperation(b1 = false, b2 = true))
    }
}