
Функциональные интерфейсы Хабр
[https://habr.com/ru/articles/677610/](https://habr.com/ru/articles/677610/)

Functional interfaces Bueldung
[https://www.baeldung.com/java-8-functional-interfaces](https://www.baeldung.com/java-8-functional-interfaces)

Functional interfaces Geeksforgeeks
[https://www.geeksforgeeks.org/functional-interfaces-java/](https://www.geeksforgeeks.org/functional-interfaces-java/)



Schema

    Supplier .get() -> Consumer .accept(T)
    
    Predicate .test(T) -> return boolean

    Function.R .apply(T t) -> Accepts an object of one type and return another type

    UnaryOperator .apply(T) -> Accept one type and return the same type

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

    Function<T, R> (Функция)
        R apply(T t)
        <V> Function<V, R> compose(Function<V, T> before)
        <V> Function<T, V> andThen(Function<R, V> after)

    BiFunction<T, U, R>
        Accept T and U and return R

    Stream.forEach( (item) -> {
        Consumer.accept()   // в forEach потребитель
    });
