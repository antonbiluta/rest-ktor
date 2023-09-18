package ru.biluta.rest.customer.routes

import io.ktor.server.application.*
import io.ktor.server.routing.*
import ru.biluta.rest.customer.services.createCustomerCart
import ru.biluta.rest.customer.services.getCustomer
import ru.biluta.rest.customer.services.getCustomerById

fun Route.customerRouting() {
    route("/customer") {
        cartRouting()
    }
}

private fun Route.cartRouting() {
    route("/cart") {
        get { call.getCustomer() }
        get("{id?}") { call.getCustomerById() }
        put {

        }
        post { call.createCustomerCart() }
        delete {

        }
    }
}

