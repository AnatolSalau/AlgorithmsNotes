Functional interfaces
[https://www.baeldung.com/java-8-functional-interfaces](https://www.baeldung.com/java-8-functional-interfaces)

Функциональные интерфейсы Хабр
[https://habr.com/ru/articles/677610/](https://habr.com/ru/articles/677610/)

Functional interfaces Bueldung
[https://www.baeldung.com/java-8-functional-interfaces](https://www.baeldung.com/java-8-functional-interfaces)

Functional interfaces Geeksforgeeks
[https://www.geeksforgeeks.org/functional-interfaces-java/](https://www.geeksforgeeks.org/functional-interfaces-java/)



Schema

    Producer.get() -> Consumer.accept(T)
    
    Predicate.test(T) -> return boolean

Interface list:

    Supplier -> Consumer

    Supplier<T> (Поставщик)
        get()

    Consumer<T> (Потребитель)
        accept(T)
        andThen(Consumer<T>)

    BiConsumer<T, U> (Двойной потребитель)
        accept(T, U)
        andThen(BiConsumer<T, U>, BiConsumer<T, U>)
