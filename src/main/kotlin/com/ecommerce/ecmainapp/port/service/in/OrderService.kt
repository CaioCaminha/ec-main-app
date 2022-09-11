package com.ecommerce.ecmainapp.port.service.`in`

import com.ecommerce.ecmainapp.domain.Order
import com.ecommerce.ecmainapp.port.`in`.OrderPortInterface
import com.ecommerce.ecmainapp.port.service.out.SendOrderService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.net.URI

@Component
class OrderService(
    val sendOrderService: SendOrderService
): OrderPortInterface{
    private val logger = LoggerFactory.getLogger("OrderService")

    override fun createOrder(order: Order): ResponseEntity<Any> {
        try{
            if(sendOrderService.sendToOrderQueue(order)){
                logger.info("Order Successfully created")
                return ResponseEntity.created(URI("")).body(order)
            }else{
                logger.error("Wasn't possible to create the order")
                throw java.lang.Exception("Wasn't possible to create the order")
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