package codepath.demos.helloworlddemo

import org.junit.Assert.assertEquals
import org.junit.Test

class GreeterTest {
    @Test
    fun testGreet() {
        val greeter = Greeter()
        val result = greeter.greet("Lucas")
        assertEquals("Hello, Lucas!", result)
    }
}