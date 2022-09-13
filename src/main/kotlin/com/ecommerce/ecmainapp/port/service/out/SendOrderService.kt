package com.ecommerce.ecmainapp.port.service.out

import com.ecommerce.ecmainapp.adapter.out.SqsPublisher
import com.ecommerce.ecmainapp.adapter.out.dto.Message
import com.ecommerce.ecmainapp.domain.Order
import com.ecommerce.ecmainapp.port.out.SendOrderPortInterface
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SendOrderService(
    val sqsPublisher: SqsPublisher
): SendOrderPortInterface {
    private val logger = LoggerFactory.getLogger("OrderService")

    override fun sendOrderToQueue(order: Order): Boolean {
        return try{
            val message: Message = Message(UUID.randomUUID(), order)
            sqsPublisher.sendMessage(message)
            logger.info("Message sent successfully")
            true
        }catch (ex: Exception){
            logger.error(ex.message)
            false
        }
    }
}