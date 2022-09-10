package com.ecommerce.ecmainapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EcMainAppApplication

fun main(args: Array<String>) {
	runApplication<EcMainAppApplication>(*args)
}
