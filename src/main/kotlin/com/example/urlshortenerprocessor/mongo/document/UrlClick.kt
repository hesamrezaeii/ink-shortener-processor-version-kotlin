package com.example.urlshortenerprocessor.mongo.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "Url-click-stats")
data class UrlClick(val shortUrl: String, val originalUrl: String, val ip: String, val userAgent: String , val date:Date) {
    @Id private lateinit var id: String
}