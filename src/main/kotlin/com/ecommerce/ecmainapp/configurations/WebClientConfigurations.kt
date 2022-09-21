package com.ecommerce.ecmainapp.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfigurations(

    val BASE_URL: String = "http://localhost:8989"
) {
    private val TIMEOUT: Int = 3000

    @Bean
    fun webClient(): WebClient{
        return WebClient.builder()
            .baseUrl(BASE_URL)
            .build()
    }
}