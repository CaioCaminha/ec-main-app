package com.ecommerce.ecmainapp.ports.`in`

import com.ecommerce.ecmainapp.domain.Order
import org.springframework.http.ResponseEntity

interface OrderControllerPortInterface {

    fun createOrder(order: Order): ResponseEntity<Any>

    fun updateOrderDetails(order: Order): ResponseEntity<Boolean>

    fun cancelOrder(order: Order): ResponseEntity<Any>

    fun listOrdersByAccount(): ResponseEntity<Any>


}