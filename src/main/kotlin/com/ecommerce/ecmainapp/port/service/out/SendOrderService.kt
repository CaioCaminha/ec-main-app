package com.ecommerce.ecmainapp.port.service.out

import com.ecommerce.ecmainapp.domain.Order
import com.ecommerce.ecmainapp.port.out.SendOrderPortInterface
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class SendOrderService(): SendOrderPortInterface {
    override fun sendToOrderQueue(order: Order): Boolean {
        TODO("Not yet implemented")
    }
}