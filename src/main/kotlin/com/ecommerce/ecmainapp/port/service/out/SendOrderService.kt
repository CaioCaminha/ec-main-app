package com.ecommerce.ecmainapp.port.service.out

import com.ecommerce.ecmainapp.adapter.out.SqsService
import com.ecommerce.ecmainapp.domain.Order
import com.ecommerce.ecmainapp.port.out.SendOrderPortInterface
import org.springframework.stereotype.Component

@Component
class SendOrderService(
    val sqsService: SqsService
): SendOrderPortInterface {
    override fun sendToOrderQueue(order: Order): Boolean {
        TODO("Not yet implemented")
    }
}