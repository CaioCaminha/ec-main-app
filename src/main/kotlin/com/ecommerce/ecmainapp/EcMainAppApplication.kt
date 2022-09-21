package com.ecommerce.ecmainapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
	exclude = [
		org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration::class,
		org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration::class,
		org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration::class
	]
)
class EcMainAppApplication

fun main(args: Array<String>) {
	runApplication<EcMainAppApplication>(*args)
}
