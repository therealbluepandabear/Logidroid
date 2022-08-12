package com.therealbluepandabear.logidroid

import com.therealbluepandabear.logidroid.models.LogicalNOT
import com.therealbluepandabear.logidroid.models.UnaryGate
import org.junit.Test

class LogicalNOTTest {
    @Test
    fun logicalNOT_test_1() {
        val logicalNOT: UnaryGate = LogicalNOT()
        assert(!logicalNOT.performOperation(b1 = true))
    }

    @Test
    fun logicalNOT_test_2() {
        val logicalNOT: UnaryGate = LogicalNOT()
        assert(logicalNOT.performOperation(b1 = false))
    }
}