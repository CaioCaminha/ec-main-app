package com.ecommerce.ecmainapp.adapter.out

import com.google.gson.Gson
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component
import com.ecommerce.ecmainapp.adapter.out.dto.Message

@Component
@Slf4j
class SqsPublisher(
    @Value("\${aws.sqs.url}")
    val endpoint: String,
    val queueMessagingTemplate: QueueMessagingTemplate
) {

    fun sendMessage(message: Message): Boolean{
        return try {
            val gson: Gson = Gson()
            queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(gson.toJson(message)).build())
            true
        } catch (ex: Exception){
            false
        }

    }
}