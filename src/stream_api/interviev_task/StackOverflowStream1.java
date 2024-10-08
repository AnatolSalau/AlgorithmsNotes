package stream_api.interviev_task;

import javafx.util.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StackOverflowStream1 {
      public static class Client {
            Integer id;
            String name;
            Integer age;
            List<Phone> phones;

            public Client(Integer id, String name, Integer age, List<Phone> phones) {
                  this.id = id;
                  this.name = name;
                  this.age = age;
                  this.phones = phones;
            }

            @Override
            public String toString() {
                  return "Client{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", age=" + age +
                        ", phones=" + phones +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                  if (this == o) return true;
                  if (o == null || getClass() != o.getClass()) return false;
                  Client client = (Client) o;
                  return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(age, client.age) && Objects.equals(phones, client.phones);
            }

            @Override
            public int hashCode() {
                  return Objects.hash(id, name, age, phones);
            }

            public Integer getAge() {
                  return age;
            }
      }

      public static class Phone {
            Long number;
            PhoneType type;

            public Phone(Long number, PhoneType type) {
                  this.number = number;
                  this.type = type;
            }

            @Override
            public boolean equals(Object o) {
                  if (this == o) return true;
                  if (o == null || getClass() != o.getClass()) return false;
                  Phone phone = (Phone) o;
                  return Objects.equals(number, phone.number) && type == phone.type;
            }

            @Override
            public int hashCode() {
                  return Objects.hash(number, type);
            }

            @Override
            public String toString() {
                  return "Phone{" +
                        "number=" + number +
                        ", type=" + type +
                        '}';
            }

            enum PhoneType {
                  STATIONARY,
                  MOBIL
            }
      }

      public static void main(String[] args) {
            Phone.PhoneType searchableType = Phone.PhoneType.STATIONARY;

            List<Client> clients = new ArrayList<>();
            clients.add(
                  new Client(1, "Client 1", 20, List.of(
                        new Phone(0001L, Phone.PhoneType.MOBIL),
                        new Phone(0002L, Phone.PhoneType.MOBIL)
                        ))
                  );
            clients.add(
                  new Client(2, "Client 1", 20, List.of(
                        new Phone(0003L, Phone.PhoneType.MOBIL),
                        new Phone(0004L, Phone.PhoneType.MOBIL)
                  ))
            );
            clients.add(
                  new Client(3, "Client 1", 20, List.of(
                        new Phone(0005L, Phone.PhoneType.MOBIL),
                        new Phone(0006L, Phone.PhoneType.STATIONARY)
                  ))
            );
            clients.add(
                  new Client(4, "Client 1", 20, List.of(
                        new Phone(0007L, Phone.PhoneType.MOBIL),
                        new Phone(0005L, Phone.PhoneType.MOBIL)
                  ))
            );
            clients.add(
                  new Client(5, "Client 1", 30, List.of(
                        new Phone(002L, Phone.PhoneType.MOBIL),
                        new Phone(0010L, Phone.PhoneType.STATIONARY)
                  ))
            );
            StackOverflowStream1 stackOverflowStream1 = new StackOverflowStream1();
            stackOverflowStream1.findClientWithStationaryPhone(clients);
            stackOverflowStream1.findClientWithMaxAgeAndStationaryNumber(clients);
            int[] arr = {5,6,1,8,9};
            Pair<Integer, Integer> minNumberAndIndex = getMinNumberAndIndex(arr);
            System.out.println("minNumberAndIndex : " + minNumberAndIndex);
            System.out.println("Result : " + "8, 3");
      }

      /*
            Как отфильтровать клиентов по полю вложенного списка (тип телефона)
            и сохранить клиента в потоке для дальнейшего поиска максимального возраста?
       */

      Stream<Client> findClientWithStationaryPhone( @NotNull List<Client> clients) {
            List<Client> result = clients.stream()
                  .filter(client -> client.phones.stream()
                        .anyMatch(phone -> phone.type.equals(Phone.PhoneType.STATIONARY))
                  )
                  .toList();
            return result.stream();
      }
      Stream<Client> findClientWithStationaryPhoneTest( @NotNull List<Client> clients) {
            List<Client> result = clients.stream()
                  .filter(client -> client.phones.stream()
                          .anyMatch(phone -> phone.type.equals(Phone.PhoneType.STATIONARY))
                  ).toList();
            return result.stream();
      }
      /*
            Найти самого возрастного клиента, которой пользуется стационарным телефоном
       */

      Client findClientWithMaxAgeAndStationaryNumber(List<Client> clients) {
            Client result = clients.stream()
                  .filter(client -> client.phones.stream()
                        .anyMatch(phone -> phone.type.equals(Phone.PhoneType.STATIONARY))
                  )
                  .max(Comparator.comparingInt(Client::getAge))
                  .orElseThrow(() -> new RuntimeException("Client not found"));
            return result;
      }

      /*
      https://javarush.com/help/76118
      Напиши метод, который возвращает минимальное число в массиве и его позицию (индекс).


      Requirements:
      1. Класс Solution должен содержать класс Pair.
      2. Класс Solution должен содержать два метода.
      3. Класс Solution должен содержать метод getMinimumAndIndex().
      4. Метод getMinimumAndIndex() должен возвращать минимальное число в массиве и его позицию (индекс).
       */
      static Pair<Integer, Integer> getMinNumberAndIndex(int[] arr) {
            Pair<Integer, Integer> array_is_empty = IntStream.range(0, arr.length - 1)
                  .mapToObj(i -> new Pair<>(arr[i], i))
                  .sorted(Comparator.comparing(Pair::getValue, Comparator.reverseOrder()))
                  .findFirst()
                  .orElseThrow(() -> new RuntimeException("Array is empty"));
            return array_is_empty;
      }
}
