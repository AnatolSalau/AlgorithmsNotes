package stream_api.interviev_task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StackOverflowStream1 {
      static class Client {
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

      static class Phone {
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
      }

      /*
            Как отфильтровать клиентов по полю вложенного списка (тип телефона)
            и сохранить клиента в потоке для дальнейшего поиска максимального возраста?
       */

      Stream<Client> findClientWithStationaryPhone(List<Client> clients) {
            List<Client> result = clients.stream()
                  .filter(client -> client.phones.stream()
                        .anyMatch(phone -> phone.type.equals(Phone.PhoneType.STATIONARY))
                  )
                  .toList();
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
}
