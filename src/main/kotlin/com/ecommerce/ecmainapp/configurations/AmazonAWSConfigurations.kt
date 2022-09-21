package com.ecommerce.ecmainapp.configurations

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class AmazonAWSConfigurations(
    @Value("\${cloud.aws.credentials.access-key}")
    val accessKey:String,
    @Value("\${cloud.aws.credentials.secret-key}")
    val secretKey: String,
    @Value("\${cloud.aws.region.static}")
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
            .withRegion(region)
            .withCredentials(AWSStaticCredentialsProvider(getBasicAWSCredentials()))
            .build()
    }

    @Bean
    @Primary
    fun s3(): AmazonS3{
        return AmazonS3ClientBuilder.standard()
            .withRegion(region)
            .withCredentials(AWSStaticCredentialsProvider(getBasicAWSCredentials()))
            .build()
    }

    fun getBasicAWSCredentials(): BasicAWSCredentials{
        return BasicAWSCredentials(accessKey, secretKey)
    }

}