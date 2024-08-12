package stream_api.skill_box_stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
      public static void main(String[] args) {
            Main main = new Main();
            main.task1();
            main.task2();
            main.task3();
            main.task4();
            main.task6();
            main.task7();
            main.task8();
      }
      /*
            Получить список всех книг библиотеки, отсортированных по году издания.
       */
      public void task1() {
            Library library = new Library();
            List list = library.getBooks().stream()
                  .sorted(Comparator.comparing(Book::getIssueYear))
                  .collect(Collectors.toList());
            System.out.println(list);
      }

      /*
            Требуется создать список рассылки (объекты типа EmailAddress) из адресов всех читателей библиотеки.
            При этом флаг согласия на рассылку учитывать не будем: библиотека закрывается, так что хотим оповестить всех.
       */

      public void task2() {
            Library library = new Library();
            List<Reader> readers = library.getReaders();
            List<EmailAddress> emailAddresses = readers.stream()
                  .map(reader -> new EmailAddress(reader.getEmail()))
                  .toList();
            System.out.println(emailAddresses);
      }
      /*
            Снова нужно получить список рассылки. Но на этот раз включаем в него только адреса читателей,
            которые согласились на рассылку.
            Дополнительно нужно проверить, что читатель взял из библиотеки больше одной книги.
       */
      public void task3() {
            Library library = new Library();
            List<Reader> readers = library.getReaders();

            List<EmailAddress> emailAddresses = readers.stream()
                  .filter(reader -> reader.isSubscriber())
                  .filter(reader -> reader.getBooks().size() > 1)
                  .map(Reader::getEmail)
                  .map(EmailAddress::new)
                  .toList();
            System.out.println();
      }
      /*
            Получить список всех книг, взятых читателями.
            Список не должен содержать дубликатов (книг одного автора, с одинаковым названием и годом издания).
       */
      public void task4() {
            Library library = new Library();
            List<Reader> readers = library.getReaders();
            List<Book> books = readers.stream()
                  .flatMap(reader -> reader.getBooks().stream())
                  .distinct()
                  .toList();
            System.out.println(books);

      }
      /*
            Проверить, взял ли кто-то из читателей библиотеки какие-нибудь книги написанные Оруэлл1.
       */

      public void task5() {
            Library library = new Library();
            List<Reader> readers = library.getReaders();

            boolean isExist = readers.stream()
                  .flatMap(reader -> reader.getBooks().stream())
                  .anyMatch(book -> book.getAuthor().equals("Оруэлл1"));

      }
      /*
            Вурнуть читателей кто, взял из  библиотеки какие-нибудь книги написанные Оруэлл1.
       */
      public void task6() {
            Library library = new Library();
            List<Reader> readers = library.getReaders();

            List<Reader> answer = readers.stream()
                  .filter(
                        reader -> reader.getBooks().stream()
                              .anyMatch(book -> book.getAuthor().equals("Оруэлл4"))
                  )
                  .toList();
            System.out.println(answer);
      }

      /*
            Узнать наибольшее число книг, которое сейчас на руках у читателя.
       */

      public void task7() {
            Library library = new Library();
            List<Reader> readers = library.getReaders();
            int reduce = readers.stream()
                  .mapToInt(reader -> reader.getBooks().size())
                  .reduce(0, (max, size) -> Math.max(size, max));
            System.out.println(reduce);
      }

      /*
            Теперь нужно не просто отправить письма всем, кто согласился на рассылку,
            — будем рассылать разные тексты двум группам:
            тем, у кого взято меньше двух книг, просто расскажем о новинках библиотеки;
            тем, у кого две книги и больше, напомним о том, что их нужно вернуть в срок.
            То есть надо написать метод, который вернёт два списка адресов (типа EmailAddress):
            с пометкой OK — если книг не больше двух, или TOO_MUCH — если их две и больше. Порядок групп не важен.
      */
      /*
      На первом шаге фильтруем читателей: оставляем только тех, кто согласился на рассылку.
            Дальше настраиваем параметры метода collect():
            задаём группировку — нужно разбить стрим на две группы по числу книг: «TOO_MUCH» или «OK»;
            в каждой группе берём email-адреса читателей (new EmailAddress (r.getEmail()))
            и собираем их в списки (Collectors.toList()).
       */
      public void task8() {
            Library library = new Library();
            List<Reader> readers = library.getReaders();
            Map<String, List<EmailAddress>> map = readers.stream()
                  .filter(Reader::isSubscriber)
                  .collect(Collectors.groupingBy(
                        reader -> reader.getBooks().size() > 2 ? "TOO_MUCH" : "OK",
                        Collectors.mapping(reader -> new EmailAddress(reader.getEmail()),
                              Collectors.toList()
                        )
                  ));
            System.out.println(map);
      }
      /*
           Если нужны не адреса, а просто списки читателей в каждой группе:
       */
      public void task9() {
            Library library = new Library();
            Map<String, List<Reader>> readerstMap = library.getReaders().stream()
                  .filter(Reader::isSubscriber)
                  .collect(Collectors.groupingBy(r -> r.getBooks().size() > 2 ? "TOO_MUCH" : "OK"));
      }

      /*
            Если для каждой группы нужны ФИО читателей из этой группы, перечисленные через запятую.
            И ещё каждый такой список ФИО нужно обернуть фигурными скобками.
            Например:
                  TOO_MUCH {Иванов Иван Иванович, Васильев Василий Васильевич}
                  OK {Семёнов Семён Семёнович}
       */

      public void task10() {
            Library library = new Library();
            Map<String, String> readersFIOMap = library.getReaders().stream()
                  .filter(Reader::isSubscriber)
                  .collect(Collectors.groupingBy(r -> r.getBooks().size() > 2 ? "TOO_MUCH" : "OK",
                        Collectors.mapping(Reader::getFio, Collectors.joining(", ", "{", "}"))));
      }
}


