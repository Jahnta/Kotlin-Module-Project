import java.util.Scanner

val scanner = Scanner(System.`in`)

fun getInput(maxInt: Int): Int {
    val notNumericError = "Некорректный ввод. Введите число."
    val notCorrectNumberError = "Введите число от 0 до $maxInt"
    while (scanner.hasNext() and !scanner.hasNextInt()) {
        println(notNumericError)
        scanner.nextLine()
    }
    val input = scanner.nextInt()
    if (input in 0..maxInt) {
        return input
    } else {
        println(notCorrectNumberError)
        return getInput(maxInt)
    }
}