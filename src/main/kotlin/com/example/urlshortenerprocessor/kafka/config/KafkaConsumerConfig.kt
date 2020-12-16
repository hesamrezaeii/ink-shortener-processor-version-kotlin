package com.example.urlshortenerprocessor.kafka.config

import com.example.urlshortenerprocessor.kafka.messageType.UrlClickMessage
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer
import java.util.*

@Configuration
class KafkaConsumerConfig {
    fun kafkaConsumerFactory(): ConsumerFactory<String, UrlClickMessage> {
        val deserializer: JsonDeserializer<UrlClickMessage> = JsonDeserializer(UrlClickMessage::class.java)
        deserializer.setRemoveTypeHeaders(false)
        deserializer.addTrustedPackages("*")
        deserializer.setUseTypeMapperForKey(true)

        val config: MutableMap<String, Any> = HashMap()

        config[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        config[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        config[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        config[ConsumerConfig.GROUP_ID_CONFIG] = "group_id"
        return DefaultKafkaConsumerFactory(config, StringDeserializer(), deserializer)
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, UrlClickMessage>? {
        val factory = ConcurrentKafkaListenerContainerFactory<String, UrlClickMessage>()
        factory.consumerFactory = kafkaConsumerFactory()
        return factory
    }
}