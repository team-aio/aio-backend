package team.aio

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AioApplication

fun main(args: Array<String>) {
    runApplication<AioApplication>(*args)
}
