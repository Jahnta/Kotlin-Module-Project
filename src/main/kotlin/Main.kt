val archives = mutableMapOf<String, MutableMap<String, String>>()
var currentArchive: String = ""

fun main() {
    App.start()
}

object App {
    fun start() {
        printMenu("архив", archives.keys, ::createArchive, ::openArchive)
    }
}


