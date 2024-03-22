package org.lab8

import kotlin.concurrent.thread

class Robot {

    fun walk() {
        val leftLegThread = thread(start = true) {
            repeat(5) {
                println("LEFT")
                Thread.sleep(500)
            }
        }

        val rightLegThread = thread(start = true) {
            repeat(5) {
                println("RIGHT")
                Thread.sleep(500)
            }
        }

        leftLegThread.join()
        rightLegThread.join()
    }
}

fun main() {
    val robot = Robot()
    robot.walk()
}