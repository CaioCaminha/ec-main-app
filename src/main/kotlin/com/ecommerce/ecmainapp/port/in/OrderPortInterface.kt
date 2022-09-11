package com.ecommerce.ecmainapp.port.`in`

import com.ecommerce.ecmainapp.domain.Order
import com.ecommerce.ecmainapp.domain.Product
import org.springframework.http.ResponseEntity
import java.util.Optional

interface OrderPortInterface {

    fun createOrder(order: Order): ResponseEntity<Any>

    fun updateOrderDetails(order: Order): ResponseEntity<Boolean>

    fun cancelOrder(order: Order): ResponseEntity<Any>

    fun listOrdersByAccount(): ResponseEntity<Any>


}