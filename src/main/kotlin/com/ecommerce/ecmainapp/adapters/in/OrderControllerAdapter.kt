package com.ecommerce.ecmainapp.adapters.`in`

import com.ecommerce.ecmainapp.domain.Order
import com.ecommerce.ecmainapp.ports.`in`.OrderControllerPortInterface
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException
import java.net.URI

@RestController
@RequestMapping(value = ["/v1/order"])
class OrderControllerAdapter(
    val orderControllerPortInterface: OrderControllerPortInterface
) {
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createOrder(@RequestBody order: Order): ResponseEntity<Any>{
        return try{
            ResponseEntity.created(URI("")).body(orderControllerPortInterface.createOrder(order))
        }catch (ex: RuntimeException){
            ResponseEntity.badRequest().body(ex.message)
        }
    }

}