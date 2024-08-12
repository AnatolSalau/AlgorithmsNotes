package stream_api.skill_box_stream;

import java.util.ArrayList;
import java.util.List;

public class Library {

      private List<Book> books;
      private List<Reader> readers;

      public Library() {
            init();
      }

      private void init() {
            books = new ArrayList<>();
            books.add(new Book("Оруэлл1", "1984", 2021));
            books.add(new Book("Оруэлл2", "1975", 1966));
            books.add(new Book("Оруэлл3", "1946", 1991));
            books.add(new Book("Оруэлл4", "1987", 2020));
            //и так далее для других книг

            readers = new ArrayList<>();
            readers.add(new Reader("Иванов Иван Иванович1", "ivanov.email1@test.ru", true));
            readers.add(new Reader("Иванов Иван Иванович2", "ivanov.email2@test.ru", false));
            readers.add(new Reader("Иванов Иван Иванович3", "ivanov.email3@test.ru", true));
            readers.add(new Reader("Иванов Иван Иванович4", "ivanov.email4@test.ru", false));
            readers.add(new Reader("Иванов Иван Иванович5", "ivanov.email5@test.ru", true));
            //и так далее для других читателей

            readers.get(0).getBooks().add(books.get(0));
            readers.get(0).getBooks().add(books.get(1));
            readers.get(0).getBooks().add(books.get(2));
            readers.get(0).getBooks().add(books.get(3));

            readers.get(1).getBooks().add(books.get(0));
            readers.get(1).getBooks().add(books.get(1));
            readers.get(1).getBooks().add(books.get(2));

            readers.get(2).getBooks().add(books.get(1));
            readers.get(2).getBooks().add(books.get(2));
            readers.get(2).getBooks().add(books.get(3));

            readers.get(3).getBooks().add(books.get(2));

            //и так далее для других читателей и взятых книг
      }

      public List<Book> getBooks() {
            return books;
      }

      public List<Reader> getReaders() {
            return readers;
      }
}