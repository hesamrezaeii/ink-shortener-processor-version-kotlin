package com.example.urlshortenerprocessor.mongo.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "hourly-click-stats")
data class ClickHourly(val shortUrl: String, val from: Date, val to: Date, val clickCount: Long) {
    @Id
    private lateinit var id: String
}