import org.example.isFibonacci
import org.example.isPerfectSquare
import org.junit.jupiter.api.Test

import kotlin.test.assertEquals

class MainKtTest {

    @Test
    fun testIsPerfectSquare() {
        assertEquals(true, isPerfectSquare(0))
        assertEquals(true, isPerfectSquare(1))
        assertEquals(true, isPerfectSquare(4))
        assertEquals(true, isPerfectSquare(9))
        assertEquals(false, isPerfectSquare(2))
        assertEquals(false, isPerfectSquare(3))
        assertEquals(false, isPerfectSquare(5))
    }

    @Test
    fun testIsFibonacci() {
        assertEquals(true, isFibonacci(0))
        assertEquals(true, isFibonacci(1))
        assertEquals(true, isFibonacci(5))
        assertEquals(true, isFibonacci(8))
        assertEquals(true, isFibonacci(13))
        assertEquals(true, isFibonacci(2))
        assertEquals(false, isFibonacci(4))
        assertEquals(false, isFibonacci(10))
    }
}
