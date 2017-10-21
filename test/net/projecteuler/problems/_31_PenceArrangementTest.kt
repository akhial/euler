package net.projecteuler.problems

import net.projecteuler.api.PenceAmount
import org.junit.Assert
import org.junit.Test

class _31_PenceArrangementTest {

    @Test fun plus() {
        Assert.assertEquals(PenceAmount(5, 7, 1, 0, 0, 0, 1, 0),
                PenceAmount(2, 4, 0, 0, 0, 0, 1, 0) + PenceAmount(3, 3, 1, 0, 0, 0, 0, 0))
    }

    @Test fun times() {
        Assert.assertEquals(PenceAmount(2, 4, 6, 8, 0, 0, 0, 0),
                PenceAmount(1, 2, 3, 4, 0, 0, 0, 0) * 2)
    }
}