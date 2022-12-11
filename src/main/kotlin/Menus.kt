fun printMenu(
    itemType: String,
    itemList: Iterable<String?>,
    createItem: () -> Unit,
    openItem: (input: Int) -> Unit
) {
    while (true) {
        println("Выберите пункт меню:")
        println("0. Создать $itemType")
        itemList.forEachIndexed { index, item -> println("${index + 1}. $item") }
        println("${itemList.count() + 1}. Выход")
        when (val input = getInput(itemList.count() + 1)) {
            0 -> createItem()
            in 1..itemList.count() -> openItem(input)
            itemList.count() + 1 -> {
                break
            }
        }
    }
}

fun openArchive(input: Int) {
    currentArchive = archives.keys.elementAt(input - 1)
    println("Открыт архив: $currentArchive\n")
    printMenu("заметку", archives[currentArchive]!!.keys, ::createNote, ::showNote)
}

fun createArchive() {
    scanner.nextLine()
    println("Введите название нового архива:")
    val name = scanner.nextLine()
    archives[name] = mutableMapOf()
    println("Создан архив: $name\n")
}

fun createNote() {
    scanner.nextLine()
    println("Введите название новой заметки:")
    val noteName = scanner.nextLine()
    println("Введите текст новой заметки:")
    val noteContent = scanner.nextLine()
    archives[currentArchive]!!.put(key=noteName, value = noteContent)
    println("Создана заметка: $noteName\n")
}

fun showNote(input: Int) {
    while (true) {
        val noteContent = archives[currentArchive]!![archives[currentArchive]!!.keys.elementAt(input - 1)]
        println("Текст заметки:\n$noteContent")
        println("Введите любой символ для возврата")
        scanner.next()
        break
    }
}