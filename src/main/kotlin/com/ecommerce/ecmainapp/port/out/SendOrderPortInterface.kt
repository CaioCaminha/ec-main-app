package com.ecommerce.ecmainapp.port.out

import com.ecommerce.ecmainapp.domain.Order

interface SendOrderPortInterface {
    fun sendOrderToQueue(order: Order): Boolean
}