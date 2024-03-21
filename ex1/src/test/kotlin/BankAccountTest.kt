import org.junit.jupiter.api.Test
import org.lab8.BankAccount
import kotlin.concurrent.thread
import kotlin.test.assertEquals

class BankAccountTest {

    @Test
    fun testDeposit() {
        val bankAccount = BankAccount(1000.0)
        bankAccount.deposit(500.0)
        assertEquals(1500.0, bankAccount.getBalance())
    }

    @Test
    fun testWithdrawSufficientFunds() {
        val bankAccount = BankAccount(1000.0)
        bankAccount.withdraw(500.0)
        assertEquals(500.0, bankAccount.getBalance())
    }

    @Test
    fun testWithdrawInsufficientFunds() {
        val bankAccount = BankAccount(1000.0)
        bankAccount.withdraw(1500.0)
        assertEquals(1000.0, bankAccount.getBalance())
    }

    @Test
    fun testMultithreadedOperations() {
        val bankAccount = BankAccount(1000.0)

        repeat(5) {
            thread {
                bankAccount.deposit(100.0)
            }
        }

        repeat(5) {
            thread {
                bankAccount.withdraw(200.0)
            }
        }

        Thread.sleep(1000) // Wait for all threads to finish

        val finalBalance = bankAccount.getBalance()
        assertEquals(500.0, finalBalance)
    }
}