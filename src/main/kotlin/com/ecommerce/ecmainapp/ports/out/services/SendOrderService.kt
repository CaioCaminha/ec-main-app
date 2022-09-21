package com.ecommerce.ecmainapp.ports.out.services

import com.ecommerce.ecmainapp.adapters.out.SqsPublisherAdapter
import com.ecommerce.ecmainapp.adapters.out.dto.Message
import com.ecommerce.ecmainapp.domain.Order
import com.ecommerce.ecmainapp.ports.out.SendOrderPortInterface
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SendOrderService(
    val endpoint: String,
    val sqsPublisherAdapter: SqsPublisherAdapter
): SendOrderPortInterface {
    private val logger = LoggerFactory.getLogger("OrderService")

    override fun sendOrderToQueue(order: Order): Boolean {
        return try{
            val message: Message = Message(UUID.randomUUID(), order)
            sqsPublisherAdapter.sendCreateOrderMessage(message, endpoint)
            logger.info("Message sent successfully")
            true
        }catch (ex: Exception){
            logger.error(ex.message)
            false
        }
    }
}