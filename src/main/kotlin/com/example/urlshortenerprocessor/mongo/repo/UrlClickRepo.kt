package com.example.urlshortenerprocessor.mongo.repo

import com.example.urlshortenerprocessor.mongo.document.UrlClick
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface UrlClickRepo : MongoRepository<UrlClick,String> {
    fun findByShortUrlAndDateBetween(shortUrl:String, from: Date, to: Date):List<UrlClick>
}