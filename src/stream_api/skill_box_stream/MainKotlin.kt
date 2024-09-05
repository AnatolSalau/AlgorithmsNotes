package stream_api.skill_box_stream

fun main() {
    task1()
    task2()
    task3()
}

/*
      Получить список всех книг библиотеки, отсортированных по году издания.
 */
private fun task1() {
    val library = Library()
    val books = library
        .books
        .toList()

    val sortedBooks = books
        .sortedBy { it.issueYear }
}

/*
      Требуется создать список рассылки (объекты типа EmailAddress) из адресов всех читателей библиотеки.
      При этом флаг согласия на рассылку учитывать не будем: библиотека закрывается, так что хотим оповестить всех.
 */
private fun task2() {
    val library = Library()
    val readers = library.readers.toList()
    val map: List<EmailAddress> = readers
        .map { it.email }
        .map { EmailAddress(it) }
    println(map)
}
/*
      Снова нужно получить список рассылки. Но на этот раз включаем в него только адреса читателей,
      которые согласились на рассылку.
      Дополнительно нужно проверить, что читатель взял из библиотеки больше одной книги.
 */

private fun task3() {
    val library = Library()
    val readers = library.readers.toList()
    val emailAddress = readers
        .filter { it.isSubscriber }
        .filter { it.books.size > 1 }
        .map { it.email }
        .map { EmailAddress(it) }
    println(emailAddress)
}


