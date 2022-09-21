package com.ecommerce.ecmainapp.ports.`in`.services

import com.ecommerce.ecmainapp.domain.Order
import com.ecommerce.ecmainapp.ports.`in`.OrderControllerPortInterface
import com.ecommerce.ecmainapp.ports.out.SendOrderPortInterface
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.net.URI


class OrderControllerService(
    val sendOrder: SendOrderPortInterface
): OrderControllerPortInterface {
    private val logger = LoggerFactory.getLogger("OrderService")

    override fun createOrder(order: Order): ResponseEntity<Any> {
        try{
            if(sendOrder.sendOrderToQueue(order)){
                logger.info("Order Successfully created")
                return ResponseEntity.created(URI("")).body(order)
            }else{
                logger.error("Wasn't possible to send message to queue")
                throw java.lang.Exception("Wasn't possible to send message to queue")
            }
        }catch (ex: Exception){
            return ResponseEntity.badRequest().body(ex.message)
        }
    }

    override fun updateOrderDetails(order: Order): ResponseEntity<Boolean> {
        TODO("Not yet implemented")
    }

    override fun cancelOrder(order: Order): ResponseEntity<Any> {
        TODO("Not yet implemented")
    }

    override fun listOrdersByAccount(): ResponseEntity<Any> {
        TODO("Not yet implemented")
    }
}