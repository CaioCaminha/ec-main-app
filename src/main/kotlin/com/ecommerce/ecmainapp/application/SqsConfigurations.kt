package com.ecommerce.ecmainapp.application

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import com.amazonaws.services.sqs.AmazonSQSClient
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import org.apache.catalina.authenticator.BasicAuthenticator.BasicCredentials
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.crypto.SecretKey

@Configuration
class SqsConfigurations(
    val accessKey:String,
    val secretKey: String,
    val region: String
) {

    @Bean
    fun queueMessagingTemplate(): QueueMessagingTemplate{
        return QueueMessagingTemplate(amazonSQSAsynq())
    }

    @Bean
    @Primary
    fun amazonSQSAsynq(): AmazonSQSAsync{
        return AmazonSQSAsyncClientBuilder.standard()
            .withRegion(Regions.US_EAST_1)
            .withCredentials(AWSStaticCredentialsProvider(BasicAWSCredentials(accessKey, secretKey)))
            .build()
    }

}