package ru.abdullaev.tally

class Greeting {
    private val platform = getPlatform()

    fun greet(): String = sayHello(platform.name)
}
