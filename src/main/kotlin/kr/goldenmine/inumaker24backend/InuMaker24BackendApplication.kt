package kr.goldenmine.inumaker24backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class InuMaker24BackendApplication

fun main(args: Array<String>) {
    runApplication<InuMaker24BackendApplication>(*args)
}
