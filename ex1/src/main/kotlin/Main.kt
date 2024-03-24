import java.util.*

/**
 * 4
 * Создать приложение для ввода пароля из командной строки и сравнения его со строкой-образцом.
 */
fun main() {
    val examplePassword = "password"

    val scanner = Scanner(System.`in`)
    print("Enter the password: ")
    val inputPassword = scanner.nextLine()

    if (inputPassword == examplePassword) {
        println("Password is correct!")
    } else {
        println("Incorrect password.")
    }
}