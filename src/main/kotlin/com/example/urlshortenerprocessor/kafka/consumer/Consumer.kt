package com.example.urlshortenerprocessor.kafka.consumer

import com.example.urlshortenerprocessor.kafka.messageType.UrlClickMessage
import com.example.urlshortenerprocessor.mongo.document.UrlClick
import com.example.urlshortenerprocessor.mongo.repo.UrlClickRepo
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class Consumer(val urlClickRepo: UrlClickRepo) {
    @KafkaListener(topics = ["kotlin-events"], groupId = "group_id" ,containerFactory = "kafkaListenerContainerFactory")
    fun consume(urlClickMessage: UrlClickMessage){
        val urlClick = UrlClick(urlClickMessage.shortUrl,urlClickMessage.originalUrl,urlClickMessage.ip,urlClickMessage.userAgent,urlClickMessage.date)
        println(urlClickRepo.save(urlClick))
    }
}