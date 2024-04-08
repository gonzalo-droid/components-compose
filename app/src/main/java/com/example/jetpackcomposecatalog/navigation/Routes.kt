package com.example.jetpackcomposecatalog.navigation

sealed class Routes(val route: String) {

    object RouteScreen1 : Routes("screen1")
    object RouteScreen2 : Routes("screen2")
    object RouteScreen3 : Routes("screen3")
    object RouteScreen4 : Routes("screen4/{age}") {
        fun createRoute(age: Int): String {
            return "screen4/$age"
        }
    }

    object RouteScreen5 : Routes("screen5?name={name}") {
        fun createRoute(name: String): String {
            return "screen5?name=$name"
        }
    }
}