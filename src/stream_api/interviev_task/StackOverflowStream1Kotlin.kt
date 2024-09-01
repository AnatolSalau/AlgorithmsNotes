package stream_api.interviev_task

import stream_api.interviev_task.StackOverflowStream1.Client
import stream_api.interviev_task.StackOverflowStream1.Phone

fun main() {
    val clients = listOf(
        Client(
            1, "Client 1", 20,
            listOf(
                Phone(1L, Phone.PhoneType.MOBIL),
                Phone(2L, Phone.PhoneType.MOBIL)
            )
        ),
        Client(
            2, "Client 1", 20,
            listOf(
                Phone(3L, Phone.PhoneType.MOBIL),
                Phone(4L, Phone.PhoneType.MOBIL)
            )
        ),
        Client(
            3, "Client 1", 20,
            listOf(
                Phone(5L, Phone.PhoneType.MOBIL),
                Phone(6L, Phone.PhoneType.STATIONARY)
            )
        ),
        Client(
            4, "Client 1", 20,
            listOf(
                Phone(7L, Phone.PhoneType.MOBIL),
                Phone(5L, Phone.PhoneType.MOBIL)
            )
        ),
        Client(
            5, "Client 1", 30,
            listOf(
                Phone(2L, Phone.PhoneType.MOBIL),
                Phone(10L, Phone.PhoneType.STATIONARY)
            )
        )
    )
    findClientWithStationaryPhoneTestKotlin(clients)
    findClientWithMaxAgeAndStationaryNumber(clients)
}

fun findClientWithStationaryPhoneTestKotlin(clients: List<Client>) {
    val find: Client = clients
        .find { it.phones.any { it.type == Phone.PhoneType.STATIONARY } }
        ?: Client(0, "", 0, listOf())

    println(find)
}

fun findClientWithMaxAgeAndStationaryNumber(clients: List<Client>) {
    val client: Client = clients
        .find { it.phones.any { it.type == Phone.PhoneType.STATIONARY } }
        ?: listOf<Client>()
            .maxBy { it.age }
    println(client)
}