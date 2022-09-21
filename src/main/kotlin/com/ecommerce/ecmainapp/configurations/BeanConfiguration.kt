package com.ecommerce.ecmainapp.configurations

import com.amazonaws.services.s3.AmazonS3
import com.ecommerce.ecmainapp.adapters.out.SqsPublisherAdapter
import com.ecommerce.ecmainapp.ports.`in`.OrderControllerPortInterface
import com.ecommerce.ecmainapp.ports.`in`.ProductControllerPortInterface
import com.ecommerce.ecmainapp.ports.`in`.services.OrderControllerService
import com.ecommerce.ecmainapp.ports.`in`.services.ProductControllerService
import com.ecommerce.ecmainapp.ports.out.SendOrderPortInterface
import com.ecommerce.ecmainapp.ports.out.services.SendOrderService
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration(
    @Value("\${cloud.aws.s3.product.bucket}")
    val bucketName: String,
    val amazonS3: AmazonS3,
    @Value("\${cloud.aws.s3.product.bucket-base-url}")
    val baseUrl: String,
    @Value("\${cloud.aws.sqs.order.end-point.uri}")
    val endpoint: String,
) {

    @Bean
    fun productControllerService(): ProductControllerPortInterface{
        return ProductControllerService(bucketName, amazonS3, baseUrl)
    }

    @Bean
    fun sendOrderService(sqsPublisherAdapter: SqsPublisherAdapter): SendOrderPortInterface{
        return SendOrderService(endpoint, sqsPublisherAdapter)
    }

    @Bean
    fun orderControllerService(sendOrderPortInterface: SendOrderPortInterface): OrderControllerPortInterface{
        return OrderControllerService(sendOrderPortInterface)
    }


}