package ru.biluta.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.biluta.rest.customer.routes.customerRouting

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        customerRouting()

    }
}
