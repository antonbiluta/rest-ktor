package ru.biluta.rest.customer.services

import ru.biluta.models.customerStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import ru.biluta.models.Customer


suspend fun ApplicationCall.getCustomer() {
    val call: ApplicationCall = this
    if (customerStorage.isNotEmpty()) {
        call.respond(customerStorage)
    } else {
        call.respondText("No customers found", status = HttpStatusCode.OK)
    }
}

suspend fun ApplicationCall.getCustomerById() {
    val call: ApplicationCall = this
    val id = call.parameters["id"] ?: return call.respondText(
        "Missing id",
        status = HttpStatusCode.BadRequest
    )
    val customer =
        customerStorage.find { it.id == id } ?: return call.respondText(
            "No customer with id $id",
            status = HttpStatusCode.NotFound
        )
    call.respond(customer)
}

suspend fun ApplicationCall.createCustomerCart() {
    val call: ApplicationCall = this
    val customer = call.receive<Customer>()
    customerStorage.add(customer)
    call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
}