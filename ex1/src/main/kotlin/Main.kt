package org.lab8

import java.util.concurrent.locks.ReentrantLock
import kotlin.random.Random

/**
 * 1.  Реализовать многопоточное приложение “Банк”. Имеется банковский счет. Сделать синхронным пополнение и снятие денежных средств на счет/со счет случайной суммой. При каждой операции (пополнения или снятие) вывести текущий баланс счета. В том случае, если денежных средств недостаточно – вывести сообщение.
 */

class BankAccount(private var balance: Double) {
    private val lock = ReentrantLock()

    fun deposit(amount: Double) {
        lock.lock()
        try {
            balance += amount
            println("Deposit: $amount, New Balance: $balance")
        } finally {
            lock.unlock()
        }
    }

    fun withdraw(amount: Double) {
        lock.lock()
        try {
            if (balance >= amount) {
                balance -= amount
                println("Withdrawal: $amount, New Balance: $balance")
            } else {
                println("Insufficient funds for withdrawal: $amount")
            }
        } finally {
            lock.unlock()
        }
    }

    fun getBalance(): Double {
        return balance
    }
}

fun main() {
    val bankAccount = BankAccount(1000.0)

    repeat(5) {
        Thread {
            val amount = Random.nextDouble(100.0, 500.0)
            bankAccount.deposit(amount)
        }.start()
    }

    repeat(5) {
        Thread {
            val amount = Random.nextDouble(100.0, 500.0)
            bankAccount.withdraw(amount)
        }.start()
    }
}