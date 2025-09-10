package demo

import org.junit.Assert.assertEquals
import org.junit.Test

class CalcTest {
    @Test
    fun testSum() {
        val calc = Calc()
        assertEquals(5, calc.sum(2, 3))
    }
}
