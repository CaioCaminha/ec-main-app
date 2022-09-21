package com.ecommerce.ecmainapp.adapters.out

import com.google.gson.Gson
import lombok.extern.slf4j.Slf4j
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component
import com.ecommerce.ecmainapp.adapters.out.dto.Message

@Component
@Slf4j
class SqsPublisherAdapter(
    val queueMessagingTemplate: QueueMessagingTemplate
) {

    fun sendCreateOrderMessage(message: Message, endpoint: String): Boolean{
        return try {
            val gson: Gson = Gson()
            queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(gson.toJson(message)).build())
            true
        } catch (ex: Exception){
            false
        }

    }

    fun sendCreateProductMessage(){

    }

    fun sendCreateAccountMessage(){

    }
}