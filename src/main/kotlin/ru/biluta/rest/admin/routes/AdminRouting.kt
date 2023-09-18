package ru.biluta.rest.admin.routes

import io.ktor.server.routing.*

fun Route.adminRouting() {
    route("/admin") {
        authRouting()
    }
}