package com.ecommerce.ecmainapp.ports.out

import com.ecommerce.ecmainapp.domain.Order

interface SendOrderPortInterface {
    fun sendOrderToQueue(order: Order): Boolean
}